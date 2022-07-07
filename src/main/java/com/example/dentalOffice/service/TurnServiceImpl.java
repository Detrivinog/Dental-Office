package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.TurnDto;
import com.example.dentalOffice.repository.ITurnRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnServiceImpl implements ITurnService{

    @Autowired
    private ITurnRepository turnRepository;

    @Autowired
    ObjectMapper mapper;

    private void createTurn(TurnDto turn){
        Turn newTurn = mapper.convertValue(turn, Turn.class);
        turnRepository.save(newTurn);
    }

    @Override
    public TurnDto getTurnById(Long id) throws Exception {
        Optional<Turn> found = turnRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, TurnDto.class);
        else
            throw new Exception("Turn Not Exist");
    }

    @Override
    public List<TurnDto> getAllTurn() {
        List<Turn> allTurn = turnRepository.findAll();
        List<TurnDto> allTurnDto = new ArrayList<>();
        for (Turn turn : allTurn)
            allTurnDto.add(mapper.convertValue(turn, TurnDto.class));

        return allTurnDto;
    }

    @Override
    public void saveTurn(TurnDto turn) {
        createTurn(turn);
    }

    @Override
    public void updateTurn(TurnDto turn) {
        createTurn(turn);

    }

    @Override
    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);
    }
}
