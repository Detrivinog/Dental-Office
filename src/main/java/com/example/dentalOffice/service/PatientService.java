package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Optional<Patient> getById(Long id);
    List<Patient> getAll();
    Patient setPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void delete(Long id);

}
