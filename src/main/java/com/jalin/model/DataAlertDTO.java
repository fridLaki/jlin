package com.jalin.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataAlertDTO {
    private String issuer;
    private String mp;
    private String port;
    private String issuerName;
    private String status;
}
