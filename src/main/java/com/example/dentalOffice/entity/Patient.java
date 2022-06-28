package com.example.dentalOffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="patients")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id")
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String address;
    private Date dischargeDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "turn_id")
    @JsonIgnore
    private List<Turn> turns;

    public Patient() {
    }
}
