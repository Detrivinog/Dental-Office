package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.Odontologist;
import com.example.dentalOffice.repository.IOdontologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologistServiceImpl implements OdontologistService{

    @Autowired
    private IOdontologistRepository odontologistRepository;

    @Override
    public Optional<Odontologist> getById(Long id) {
        return odontologistRepository.findById(id);
    }

    @Override
    public List<Odontologist> getAll() {
        return odontologistRepository.findAll();
    }

    @Override
    public Odontologist setOdontologist(Odontologist odontologist) {
        return odontologistRepository.save(odontologist);
    }

    @Override
    public Odontologist updateOdontologist(Odontologist odontologist) {
        return odontologistRepository.save(odontologist);
    }

    @Override
    public void delete(Long id) {
        odontologistRepository.deleteById(id);
    }
}
