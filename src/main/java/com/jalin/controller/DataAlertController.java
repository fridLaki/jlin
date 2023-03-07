package com.jalin.controller;

import com.jalin.model.DataAlertDTO;
import com.jalin.service.EmailService;
import com.jalin.service.EmailServiceGmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DataAlertController {

    private EmailService emailServiceGmail;

    @Autowired
    public void setEmailServiceGmail(EmailServiceGmail emailServiceGmail) {
        this.emailServiceGmail = emailServiceGmail;
    }

    public List<DataAlertDTO> readDataAlert(File file) {
        List<DataAlertDTO> listOfDataAlertDTOs = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

                bufferedReader.lines().forEach(line -> {
                    String arrayAlertData[] = line.split("\\;");
                    DataAlertDTO dataAlertDTO = DataAlertDTO.builder()
                            .issuer(arrayAlertData[0])
                            .mp(arrayAlertData[1])
                            .port(arrayAlertData[2])
                            .issuerName(arrayAlertData[3])
                            .status(arrayAlertData[4])
                            .build();
                    listOfDataAlertDTOs.add(dataAlertDTO);
                });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfDataAlertDTOs;
    }

    public void sendEmailDataAlert(String[] listIssuerToSend, List<DataAlertDTO> listDataAlert) {

        Arrays.stream(listIssuerToSend).forEach(issuer -> {
            List<DataAlertDTO> listOfEnvi = new ArrayList<>();
            listDataAlert.stream()
                    .filter(dataAlertDTO -> dataAlertDTO.getIssuer().equals(issuer)
                            && !issuer.isEmpty() && !dataAlertDTO.getIssuer().isEmpty())
                            .forEach(alertDTO -> {
                                DataAlertDTO dataAlertDTO = DataAlertDTO.builder()
                                        .issuer(alertDTO.getIssuer())
                                        .mp(alertDTO.getMp())
                                        .port(alertDTO.getPort())
                                        .status(alertDTO.getStatus())
                                        .build();
                                listOfEnvi.add(dataAlertDTO);
                            });
            emailServiceGmail.sendEmail(issuer, listOfEnvi);
        });
    }
}
