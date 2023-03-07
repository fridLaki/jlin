package com.jalin.service;

import com.jalin.model.DataAlertDTO;

import java.util.List;

public interface EmailService {
    String sendEmail(String issuer, List<DataAlertDTO> listOfEnvi);
}
