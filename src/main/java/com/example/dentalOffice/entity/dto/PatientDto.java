package com.example.dentalOffice.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientDto implements Serializable {
    private final Long id;
    private final String dni;
    private final String name;
    private final String lastname;
    private final String address;
    private final Date dischargeDate;
}
