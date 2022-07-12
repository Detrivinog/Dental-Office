package com.example.dentalOffice.repository;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.TurnDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ITurnRepository extends JpaRepository<Turn, Long> {

//    @Query("select t from turns t where t.patient_id = ?1")
    Set<Turn> getTurnByPatientId(Long id);
//
//    @Query("select t from turns t where t.odontologist_id = ?1")
    Set<Turn> getTurnByOdontologistId(Long id);
}
