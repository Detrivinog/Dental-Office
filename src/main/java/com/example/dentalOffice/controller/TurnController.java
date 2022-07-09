package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.dto.TurnDto;
import com.example.dentalOffice.exceptions.BadRequestException;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;
import com.example.dentalOffice.service.TurnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    TurnServiceImpl turnService;

    @GetMapping("/list")
    public ResponseEntity<Set<TurnDto>> getAllTurn(){
        return ResponseEntity.ok(turnService.getAllTurn());
    }

    @GetMapping("/{id}")
    public TurnDto getTurById(@PathVariable Long id) throws ResourceNotFoundException {
        return turnService.getTurnById(id);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateTurn(@RequestBody TurnDto turn) throws ResourceNotFoundException {
        turnService.updateTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) throws ResourceNotFoundException {
        turnService.deleteTurn(id);
        return ResponseEntity.ok("Turn deleted");
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveTurn(@RequestBody Turn turn) throws BadRequestException, ResourceNotFoundException {
        turnService.saveTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @GetMapping("/patient/{id}")
//    public ResponseEntity<Set<TurnDto>> getTurnByPatientId(@PathVariable Long id) throws Exception{
//        return ResponseEntity.ok(turnService.getTurnByPatientId(id));
//    }
//
//    @GetMapping("/Odontologist/{id}")
//    public ResponseEntity<Set<TurnDto>> getTurnByOdontologistId(@PathVariable Long id) throws Exception{
//        return ResponseEntity.ok(turnService.getTurnByOdontologistId(id));
//    }

}
