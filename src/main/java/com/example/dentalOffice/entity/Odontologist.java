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
    @Column(name = "odontologist_id")
    private Long id;
    private String license;
    private String name;
    private String lastname;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "turn_id")
    @JsonIgnore
    private List<Turn> turns;

    public Odontologist() {
    }
}
