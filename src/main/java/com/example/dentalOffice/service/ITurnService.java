package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.TurnDto;

import java.util.List;

public interface ITurnService {
    TurnDto getTurnById(Long id) throws Exception;
    List<TurnDto> getAllTurn();
    void saveTurn(Turn turn);
    void updateTurn(TurnDto turn);
    void deleteTurn(Long id);
}
