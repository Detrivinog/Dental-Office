package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.TurnDto;

import java.util.List;
import java.util.Set;

public interface ITurnService {
    TurnDto getTurnById(Long id) throws Exception;
    Set<TurnDto> getAllTurn();
    void saveTurn(Turn turn);
    void updateTurn(TurnDto turn);
    void deleteTurn(Long id);

//    Set<TurnDto> getTurnByPatientId(Long id) throws Exception;
//    Set<TurnDto> getTurnByOdontologistId(Long id) throws Exception;
}
