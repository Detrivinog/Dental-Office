package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;

import java.util.List;
import java.util.Optional;

public interface IOdontologistService {

    Optional<Odontologist> getOdontologistById(Long id);
    List<Odontologist> getAllOdontologist();
    Odontologist saveOdontologist(Odontologist odontologist);
    Odontologist updateOdontologist(Odontologist odontologist);
    void deleteOdontologist(Long id);
    
}
