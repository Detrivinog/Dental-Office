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

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        ResponseEntity<Patient> response = null;
        if (patient.getId() != null && patientService.getPatientById(patient.getId()).isPresent()){
            response = ResponseEntity.ok(patientService.updatePatient(patient));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PostMapping("/")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

}
