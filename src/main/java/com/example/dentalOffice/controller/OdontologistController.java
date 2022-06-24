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

    @GetMapping("/")
    public List<Odontologist> getAll(){
        return odontologistService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Odontologist> getById(@PathVariable Long id){
        return odontologistService.getById(id);
    }

    @PutMapping("/")
    public Odontologist update(@RequestBody Odontologist o){
        return odontologistService.updateOdontologist(o);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        odontologistService.delete(id);
    }

    @PostMapping("/")
    public Odontologist setOdontologist(@RequestBody Odontologist o){
        return odontologistService.setOdontologist(o);
    }

}
