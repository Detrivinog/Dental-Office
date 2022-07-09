package com.example.dentalOffice.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OdontologistDto implements Serializable {
    private final Long id;
    private final String license;
    private final String name;
    private final String lastname;
}
