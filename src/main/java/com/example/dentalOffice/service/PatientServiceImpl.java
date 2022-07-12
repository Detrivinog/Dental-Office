package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Patient;
import com.example.dentalOffice.entity.dto.PatientDto;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;
import com.example.dentalOffice.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    private void createPatient(PatientDto patient){
        Patient newPatient = mapper.convertValue(patient, Patient.class);
        patientRepository.save(newPatient);
    }

    @Override
    public PatientDto getPatientById(Long id) throws ResourceNotFoundException {
        Optional<Patient> found = patientRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, PatientDto.class);
        else
            throw new ResourceNotFoundException("Patient Not Exist with id: "+id);
    }

    @Override
    public Set<PatientDto> getAllPatient() {
        List<Patient> allPatient = patientRepository.findAll();
        Set<PatientDto> allPatientDto = new HashSet<>();
        for (Patient patient: allPatient)
            allPatientDto.add(mapper.convertValue(patient, PatientDto.class));

        return allPatientDto;
    }

    @Override
    public void savePatient(PatientDto patient) {
        createPatient(patient);
    }

    @Override
    public void updatePatient(PatientDto patient) throws ResourceNotFoundException {
        Optional<Patient> found = patientRepository.findById(patient.getId());
        if (found.isPresent())
            createPatient(patient);
        else
            throw new ResourceNotFoundException("Patient Not Exist with id: "+patient.getId());
    }

    @Override
    public void deletePatient(Long id) throws ResourceNotFoundException {
        Optional<Patient> found = patientRepository.findById(id);
        if (found.isPresent())
            patientRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Patient Not Exist with id: "+id);
    }
}
