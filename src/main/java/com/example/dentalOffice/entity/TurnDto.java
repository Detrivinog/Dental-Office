package com.example.dentalOffice.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class TurnDto implements Serializable {
    private final Long id;
    private final Date date;
    private final Odontologist odontologist;
    private final Patient patient;
}
