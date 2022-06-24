package com.example.dentalOffice.repository;

import com.example.dentalOffice.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
