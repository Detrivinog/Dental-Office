package com.example.dentalOffice.repository;

import com.example.dentalOffice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
