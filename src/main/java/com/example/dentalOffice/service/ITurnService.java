package com.example.dentalOffice.service;


import com.example.dentalOffice.entity.Turn;

import java.util.List;
import java.util.Optional;

public interface ITurnService {
    Optional<Turn> getTurnById(Long id);
    List<Turn> getAllTurn();
    Turn saveTurn(Turn turn);
    Turn updateTurn(Turn turn);
    void deleteTurn(Long id);
}
