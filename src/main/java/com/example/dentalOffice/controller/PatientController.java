package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.dto.PatientDto;
import com.example.dentalOffice.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/list")
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable Long id) throws Exception{
        return patientService.getPatientById(id);
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDto patient){
        patientService.updatePatient(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PostMapping("/")
    public ResponseEntity<?> savePatient(@RequestBody PatientDto patient){
        patientService.savePatient(patient);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
