package com.example.dentalOffice.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TurnDto implements Serializable {
    private final Long id;
    private final LocalDate date;
}
