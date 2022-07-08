package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Turn;
import com.example.dentalOffice.entity.TurnDto;
import com.example.dentalOffice.service.TurnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    TurnServiceImpl turnService;


    @GetMapping("/list")
    public ResponseEntity<List<TurnDto>> getAllTurn(){
        return ResponseEntity.ok(turnService.getAllTurn());
    }

    @GetMapping("/{id}")
    public TurnDto getTurById(@PathVariable Long id) throws Exception{
        return turnService.getTurnById(id);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateTurn(@RequestBody TurnDto turn){
        turnService.updateTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id){
        turnService.deleteTurn(id);
        return ResponseEntity.ok("Turn deleted");
    }

    @PostMapping("/")
    public ResponseEntity<?> saveTurn(@RequestBody Turn turn){
        turnService.saveTurn(turn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
