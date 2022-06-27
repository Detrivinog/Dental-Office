package com.example.dentalOffice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "odontologists")
@Getter
@Setter
public class Odontologist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String license;
    private String name;
    private String lastname;

    @ManyToOne
    @JsonIgnore
    private List<Turn> turns;

    public Odontologist() {
    }
}
