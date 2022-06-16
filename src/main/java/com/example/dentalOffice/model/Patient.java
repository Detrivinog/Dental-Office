package com.example.dentalOffice.model;

import java.sql.Date;

public class Patient {

    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String address;
    private Date dischargeDate;

    public Patient() {
    }

    public Patient(Long id, String dni, String name, String lastname, String address, Date dischargeDate) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dischargeDate = dischargeDate;
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

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
