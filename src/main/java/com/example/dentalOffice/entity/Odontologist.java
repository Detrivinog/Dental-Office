package com.example.dentalOffice.entity;

public class Odontologist {

    private Long id;
    private String license;
    private String name;
    private String lastname;

    public Odontologist() {
    }

    public Odontologist(Long id, String licesnsePlate, String name, String lastname) {
        this.id = id;
        this.license = licesnsePlate;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
}
