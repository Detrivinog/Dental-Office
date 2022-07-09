package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.dto.PatientDto;

import java.util.Set;

public interface IPatientService {

    PatientDto getPatientById(Long id) throws Exception;
    Set<PatientDto> getAllPatient();
    void savePatient(PatientDto patient);
    void updatePatient(PatientDto patient);
    void deletePatient(Long id);

}
