package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;

import java.util.List;
import java.util.Optional;

public interface OdontologistService {

    Optional<Odontologist> getById(Long id);
    List<Odontologist> getAll();
    Odontologist setOdontologist(Odontologist odontologist);
    Odontologist updateOdontologist(Odontologist odontologist);
    void delete(Long id);
    
}
