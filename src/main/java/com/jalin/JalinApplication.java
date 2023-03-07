package com.jalin;

import com.jalin.controller.DataAlertController;
import com.jalin.model.DataAlertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class JalinApplication implements CommandLineRunner {

    @Value("${data.issuer}")
    private String issuer;
    @Autowired
    private DataAlertController dataAlertController;

    public static void main(String[] args) {
        SpringApplication.run(JalinApplication.class, args);
    }

    @Override
    public void run(String... args) {
        File file = new File("C:\\Users\\Fridz\\IdeaProjects\\Jalin\\src\\Data Alert.txt");

        List<DataAlertDTO> listDataAlert = dataAlertController.readDataAlert(file);
        dataAlertController.sendEmailDataAlert(issuer.split("\\;"), listDataAlert);
    }
}
