package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.dto.OdontologistDto;
import com.example.dentalOffice.exceptions.BadRequestException;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologistService {


    OdontologistDto getOdontologistById(Long id) throws ResourceNotFoundException;
    Set<OdontologistDto> getAllOdontologist();
    void saveOdontologist(OdontologistDto odontologist);
    void updateOdontologist(OdontologistDto odontologist) throws ResourceNotFoundException;
    void deleteOdontologist(Long id) throws ResourceNotFoundException;
    
}
