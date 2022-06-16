package com.example.dentalOffice.services;

import com.example.dentalOffice.dao.IDao;
import com.example.dentalOffice.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private IDao<Patient> patientIDao;

    public PatientService(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }

    public PatientService() {
    }

    public Patient setPatient(Patient patient){
        return patientIDao.set(patient);
    }

    public Patient updatePatient(Patient patient){
        return patientIDao.update(patient);
    }

    public Patient getById(Long id){
        return patientIDao.get(id);
    }

    public List<Patient> getAll(){
        return patientIDao.getAll();
    }

    public void delete(Long id){
        patientIDao.delete(id);
    }
}
