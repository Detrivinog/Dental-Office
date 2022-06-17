package com.example.dentalOffice.controllers;

import com.example.dentalOffice.dao.Impl.OdontologistDaoH2;
import com.example.dentalOffice.model.Odontologist;
import com.example.dentalOffice.services.OdontologistService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/odontologist")
public class OdontologistController {

    private OdontologistService odontologistService = new OdontologistService(new OdontologistDaoH2);

    @GetMapping("/")
    public List<Odontologist> getAll(){
        return odontologistService.getAll();
    }

    @GetMapping("/{id}")
    public Odontologist getById(@PathVariable Long id){
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
