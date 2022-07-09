package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;
import com.example.dentalOffice.entity.dto.OdontologistDto;
import com.example.dentalOffice.repository.IOdontologistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public OdontologistDto getOdontologistById(Long id) throws Exception {
        Optional<Odontologist> found = odontologistRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, OdontologistDto.class);
        else
            throw new Exception("Odontologist Not Exist");
    }

    @Override
    public List<OdontologistDto> getAllOdontologist() {
        List<Odontologist> allOdontologist = odontologistRepository.findAll();
        List<OdontologistDto> allOdontologistDto = new ArrayList<OdontologistDto>();
        for (Odontologist odontologist: allOdontologist)
            allOdontologistDto.add(mapper.convertValue(odontologist, OdontologistDto.class));

        return allOdontologistDto;
    }

    @Override
    public void saveOdontologist(OdontologistDto odontologist) {
        createOdontologist(odontologist);
    }

    @Override
    public void updateOdontologist(OdontologistDto odontologist) {
        createOdontologist(odontologist);
    }

    @Override
    public void deleteOdontologist(Long id) {
        odontologistRepository.deleteById(id);
    }
}
