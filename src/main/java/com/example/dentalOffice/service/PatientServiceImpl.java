package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Patient;
import com.example.dentalOffice.entity.PatientDto;
import com.example.dentalOffice.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public PatientDto getPatientById(Long id) throws Exception {
        Optional<Patient> found = patientRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, PatientDto.class);
        else
            throw new Exception("Patient Not Exist");
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> allPatient = patientRepository.findAll();
        List<PatientDto> allPatientDto = new ArrayList<PatientDto>();
        for (Patient patient: allPatient)
            allPatientDto.add(mapper.convertValue(patient, PatientDto.class));

        return allPatientDto;
    }

    @Override
    public void savePatient(PatientDto patient) {
        createPatient(patient);
    }

    @Override
    public void updatePatient(PatientDto patient) {
        createPatient(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
