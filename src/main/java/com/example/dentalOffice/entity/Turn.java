package com.example.dentalOffice.entity;

import java.time.LocalDate;

public class Turn {
    private Long id;
    private LocalDate date;
    private Odontologist odontologist;
    private Patient patient;

    public Turn() {
    }

    public Turn(LocalDate date, Odontologist odontologist, Patient patient) {
        this.date = date;
        this.odontologist = odontologist;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Odontologist getOdontologist() {
        return odontologist;
    }

    public void setOdontologist(Odontologist odontologist) {
        this.odontologist = odontologist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
