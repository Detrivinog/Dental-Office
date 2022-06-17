package com.example.dentalOffice.controllers;

import com.example.dentalOffice.dao.Impl.PatientDaoH2;
import com.example.dentalOffice.model.Patient;
import com.example.dentalOffice.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    PatientService patientService = new PatientService(new PatientDaoH2());

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @PutMapping("/")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        ResponseEntity<Patient> response = null;
        if (patient.getId() != null && patientService.getById(patient.getId()) != null){
            response = ResponseEntity.ok(patientService.updatePatient(patient));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PostMapping("/")
    public ResponseEntity<Patient> setPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.setPatient(patient));
    }

}
