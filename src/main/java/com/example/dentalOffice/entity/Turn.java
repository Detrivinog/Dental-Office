package com.example.dentalOffice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "turns")
@Getter @Setter
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turn_id")
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "odontologist_id")
    private Odontologist odontologist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Turn() {
    }
}
