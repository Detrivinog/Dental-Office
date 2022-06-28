package com.example.dentalOffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "turn_id")
    private Long id;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Odontologist odontologist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    public Turn() {
    }
}
