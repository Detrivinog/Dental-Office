package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.dto.OdontologistDto;

import java.util.Set;

public interface IOdontologistService {


    OdontologistDto getOdontologistById(Long id) throws Exception;
    Set<OdontologistDto> getAllOdontologist();
    void saveOdontologist(OdontologistDto odontologist);
    void updateOdontologist(OdontologistDto odontologist);
    void deleteOdontologist(Long id);
    
}
