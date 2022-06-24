package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Patient;
import com.example.dentalOffice.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @PutMapping("/")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        ResponseEntity<Patient> response = null;
        if (patient.getId() != null && patientService.getById(patient.getId()).isPresent()){
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
