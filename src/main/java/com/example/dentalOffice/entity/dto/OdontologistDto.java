package com.example.dentalOffice.entity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter @Setter
public class OdontologistDto implements Serializable {
    private Long id;
    private String license;
    private String name;
    private String lastname;
}
