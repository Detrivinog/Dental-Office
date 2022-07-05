package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.OdontologistDto;

import java.util.List;

public interface IOdontologistService {


    OdontologistDto getOdontologistById(Long id) throws Exception;
    List<OdontologistDto> getAllOdontologist();
    void saveOdontologist(OdontologistDto odontologist);
    void updateOdontologist(OdontologistDto odontologist);
    void deleteOdontologist(Long id);
    
}
