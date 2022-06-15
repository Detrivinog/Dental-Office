package com.example.dentalOffice.model;

import java.time.LocalDate;

public class Patient {

    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String address;
    private LocalDate discahargeDate;

    public Patient() {
    }

    public Patient(String dni, String name, String lastname, LocalDate discahargeDate) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.discahargeDate = discahargeDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDiscahargeDate() {
        return discahargeDate;
    }

    public void setDiscahargeDate(LocalDate discahargeDate) {
        this.discahargeDate = discahargeDate;
    }
}
