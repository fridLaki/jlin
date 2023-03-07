package com.jalin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DataAlert {

    @Id
    private Long id;
    private String issuer;
    private String mp;
    private String port;
    private String issuerName;
    private String status;
}
