package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;
import com.example.dentalOffice.entity.dto.OdontologistDto;
import com.example.dentalOffice.exceptions.ResourceNotFoundException;
import com.example.dentalOffice.repository.IOdontologistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologistServiceImpl implements IOdontologistService {

    @Autowired
    private IOdontologistRepository odontologistRepository;

    @Autowired
    ObjectMapper mapper;

    private void createOdontologist(OdontologistDto odontologist){
        Odontologist newOdontologist = mapper.convertValue(odontologist, Odontologist.class);
        odontologistRepository.save(newOdontologist);
    }

    @Override
    public OdontologistDto getOdontologistById(Long id) throws ResourceNotFoundException {
        Optional<Odontologist> found = odontologistRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, OdontologistDto.class);
        else
            throw new ResourceNotFoundException("Odontologist Not Exist with id: "+id);
    }

    @Override
    public Set<OdontologistDto> getAllOdontologist() {
        List<Odontologist> allOdontologist = odontologistRepository.findAll();
        Set<OdontologistDto> allOdontologistDto = new HashSet<>();
        for (Odontologist odontologist: allOdontologist)
            allOdontologistDto.add(mapper.convertValue(odontologist, OdontologistDto.class));

        return allOdontologistDto;
    }

    @Override
    public void saveOdontologist(OdontologistDto odontologist) {
        createOdontologist(odontologist);
    }

    @Override
    public void updateOdontologist(OdontologistDto odontologist) throws ResourceNotFoundException {
        Optional<Odontologist> found = odontologistRepository.findById(odontologist.getId());
        if (found.isPresent())
            createOdontologist(odontologist);
        else
            throw new ResourceNotFoundException("Odontologist Not Exist with id: "+odontologist.getId());
    }

    @Override
    public void deleteOdontologist(Long id) throws ResourceNotFoundException{
        Optional<Odontologist> found = odontologistRepository.findById(id);
        if (found.isPresent())
            odontologistRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Odontologist Not Exist with id: "+id);
    }
}
