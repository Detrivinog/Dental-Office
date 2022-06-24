package com.example.dentalOffice.repository;

import com.example.dentalOffice.entity.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologistRepository extends JpaRepository<Odontologist, Long> {
}
