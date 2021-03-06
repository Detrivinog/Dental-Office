package com.example.dentalOffice.repository;

import com.example.dentalOffice.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ITurnRepository extends JpaRepository<Turn, Long> {

//    @Query("select t from turns t where t.patient_id = ?1")
    Set<Turn> getTurnByPatientId(Long id);

//    @Query("select t from turns t where t.odontologist_id = ?1")
    Set<Turn> getTurnByOdontologistId(Long id);
}
