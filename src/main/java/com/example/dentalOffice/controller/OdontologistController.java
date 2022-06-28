package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Odontologist;
import com.example.dentalOffice.service.OdontologistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologist")
public class OdontologistController {

    @Autowired
    private OdontologistServiceImpl odontologistService;

    @GetMapping("/list")
    public List<Odontologist> getAllOdontologist(){
        return odontologistService.getAllOdontologist();
    }

    @GetMapping("/{id}")
    public Optional<Odontologist> getOdontologistById(@PathVariable Long id){
        return odontologistService.getOdontologistById(id);
    }

    @PutMapping("/")
    public Odontologist updateOdontologist(@RequestBody Odontologist o){
        return odontologistService.updateOdontologist(o);
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologist(@PathVariable Long id){
        odontologistService.deleteOdontologist(id);
    }

    @PostMapping("/")
    public Odontologist saveOdontologist(@RequestBody Odontologist o){
        return odontologistService.saveOdontologist(o);
    }

}
