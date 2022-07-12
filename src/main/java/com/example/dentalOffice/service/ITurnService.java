package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.TurnDto;
import com.example.dentalOffice.exceptions.BadRequestException;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface ITurnService {
    TurnDto getTurnById(Long id) throws ResourceNotFoundException;
    Set<TurnDto> getAllTurn();
    void saveTurn(Turn turn) throws BadRequestException, ResourceNotFoundException;
    void updateTurn(TurnDto turn) throws ResourceNotFoundException;
    void deleteTurn(Long id) throws ResourceNotFoundException;

    Set<TurnDto> getTurnByPatientId(Long id) throws Exception;
    Set<TurnDto> getTurnByOdontologistId(Long id) throws Exception;
}
