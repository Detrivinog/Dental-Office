package com.example.dentalOffice.service;


import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.OdontologistDto;
import com.example.dentalOffice.entity.dto.PatientDto;
import com.example.dentalOffice.entity.dto.TurnDto;
import com.example.dentalOffice.exceptions.BadRequestException;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;
import com.example.dentalOffice.repository.ITurnRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnServiceImpl implements ITurnService{

    @Autowired
    private ITurnRepository turnRepository;

    @Autowired
    private OdontologistServiceImpl odontologistService;

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    ObjectMapper mapper;

    private void createTurn(TurnDto turn){
        Turn newTurn = mapper.convertValue(turn, Turn.class);
        turnRepository.save(newTurn);
    }

    @Override
    public TurnDto getTurnById(Long id) throws ResourceNotFoundException {
        Optional<Turn> found = turnRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, TurnDto.class);
        else
            throw new ResourceNotFoundException("Turn Not Exist with id: "+id);
    }

    @Override
    public Set<TurnDto> getAllTurn() {
        List<Turn> allTurn = turnRepository.findAll();
        Set<TurnDto> allTurnDto = new HashSet<>();
        for (Turn turn : allTurn)
            allTurnDto.add(mapper.convertValue(turn, TurnDto.class));

        return allTurnDto;
    }

    @Override
    public void saveTurn(Turn turn) throws BadRequestException, ResourceNotFoundException {
        Optional<OdontologistDto> odontologist = Optional.ofNullable(odontologistService.getOdontologistById(turn.getOdontologist().getId()));
        Optional<PatientDto> patient =  Optional.ofNullable(patientService.getPatientById(turn.getPatient().getId()));
        if (odontologist.isPresent() && patient.isPresent())
            turnRepository.save(turn);
        else
            throw new BadRequestException("Odontologist Not Exist with id: "+ turn.getOdontologist().getId()+"or Patient Not Exist with id: "+ turn.getPatient().getId());
    }

    @Override
    public void updateTurn(TurnDto turn) throws ResourceNotFoundException{
        Optional<Turn> found = turnRepository.findById(turn.getId());
        if (found.isPresent())
            createTurn(turn);
        else
            throw new ResourceNotFoundException("Turn Not Exist with id: "+turn.getId());

    }

    @Override
    public void deleteTurn(Long id) throws ResourceNotFoundException {
        Optional<Turn> found = turnRepository.findById(id);
        if (found.isPresent())
            turnRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Turn Not Exist with id: "+id);
    }

    @Override
    public Set<TurnDto> getTurnByPatientId(Long id) throws Exception {
        Set<Turn> allTurn = turnRepository.getTurnByPatientId(id);
        Set<TurnDto> allTurnDto = new HashSet<>();
        for (Turn turn : allTurn)
            allTurnDto.add(mapper.convertValue(turn, TurnDto.class));

        return allTurnDto;
    }

    @Override
    public Set<TurnDto> getTurnByOdontologistId(Long id) throws Exception {
        Set<Turn> allTurn = turnRepository.getTurnByOdontologistId(id);
        Set<TurnDto> allTurnDto = new HashSet<>();
        for (Turn turn : allTurn)
            allTurnDto.add(mapper.convertValue(turn, TurnDto.class));

        return allTurnDto;
    }
}
