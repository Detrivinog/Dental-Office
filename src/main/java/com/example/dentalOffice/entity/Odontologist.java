package com.example.dentalOffice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologists")
@Getter
@Setter
public class Odontologist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odontologist_id")
    private Long id;
    private String license;
    private String name;
    private String lastname;

    @OneToMany(mappedBy = "odontologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turn> turns;

    public Odontologist() {
    }
}
