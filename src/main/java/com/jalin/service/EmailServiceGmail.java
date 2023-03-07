package com.jalin.service;

import com.jalin.model.DataAlertDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceGmail implements EmailService{
    @Override
    public String sendEmail(String issuer, List<DataAlertDTO> listOfEnvi) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selamat Siang Rekan " + issuer + ",\n");
        stringBuilder.append("\n");
        stringBuilder.append("Mohon bantuannya untuk Sign on pada Envi berikut: \n");
        for (DataAlertDTO alertDTO: listOfEnvi) {
            stringBuilder.append("- Envi "+ alertDTO.getMp() + " Port " + alertDTO.getPort() + " terpantau " + alertDTO.getStatus() +"\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Terima kasih\n");
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
