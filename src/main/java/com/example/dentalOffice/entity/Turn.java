package com.example.dentalOffice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "turns")
@Getter @Setter
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;

    @OneToMany
    @JoinColumn(name = "odontologist_id", nullable = false)
    private Odontologist odontologist;

    @OneToMany
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Turn() {
    }
}
