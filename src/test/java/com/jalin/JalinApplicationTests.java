package com.jalin;

import com.jalin.controller.DataAlertController;
import com.jalin.service.EmailServiceGmail;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JalinApplicationTests {

    private EmailServiceGmail emailServiceGmail;
    private DataAlertController dataAlertController;

    @Autowired
    public void setEmailServiceGmail(EmailServiceGmail emailServiceGmail) {
        this.emailServiceGmail = emailServiceGmail;
    }

    @Autowired
    public void setDataAlertController(DataAlertController dataAlertController) {
        this.dataAlertController = dataAlertController;
    }

    @Test
    void checkDI() {
        assertNotNull(emailServiceGmail);
        assertNotNull(dataAlertController);
    }
}
