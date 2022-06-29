package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;
import com.example.dentalOffice.entity.OdontologistDto;

import java.util.List;
import java.util.Optional;

public interface IOdontologistService {

    void createOdontologist(OdontologistDto odontologist);
    Optional<OdontologistDto> getOdontologistById(Long id);
    List<OdontologistDto> getAllOdontologist();
    Odontologist saveOdontologist(OdontologistDto odontologist);
    Odontologist updateOdontologist(OdontologistDto odontologist);
    void deleteOdontologist(Long id);
    
}
