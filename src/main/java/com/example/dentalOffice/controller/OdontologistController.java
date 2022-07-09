package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.dto.OdontologistDto;
import com.example.dentalOffice.service.OdontologistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologist")
public class OdontologistController {

    @Autowired
    private OdontologistServiceImpl odontologistService;

    @GetMapping("/list")
    public Set<OdontologistDto> getAllOdontologist(){
        return odontologistService.getAllOdontologist();
    }

    @GetMapping("/{id}")
    public OdontologistDto getOdontologistById(@PathVariable Long id) throws Exception {
        return odontologistService.getOdontologistById(id);
    }

    @PutMapping("/")
    public void updateOdontologist(@RequestBody OdontologistDto o){
        odontologistService.updateOdontologist(o);
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologist(@PathVariable Long id){
        odontologistService.deleteOdontologist(id);
    }

    @PostMapping("/register")
    public void saveOdontologist(@RequestBody OdontologistDto o){
        odontologistService.saveOdontologist(o);
    }

}
