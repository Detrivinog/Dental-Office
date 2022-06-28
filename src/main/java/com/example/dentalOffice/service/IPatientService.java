package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    Optional<Patient> getPatientById(Long id);
    List<Patient> getAllPatient();
    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);

}
