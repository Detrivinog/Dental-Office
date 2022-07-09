package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.dto.PatientDto;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPatientService {

    PatientDto getPatientById(Long id) throws ResourceNotFoundException;
    Set<PatientDto> getAllPatient();
    void savePatient(PatientDto patient);
    void updatePatient(PatientDto patient) throws ResourceNotFoundException;
    void deletePatient(Long id) throws ResourceNotFoundException;

}
