package com.example.dentalOffice.services;

import com.example.dentalOffice.dao.IDao;
import com.example.dentalOffice.model.Odontologist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologistService {

    private IDao<Odontologist> odontologistIDao;

    public  OdontologistService(IDao<Odontologist> odontologistDao){
        this.odontologistIDao = odontologistDao;
    }

    public OdontologistService() {
    }

    public Odontologist getById(Long id){
        return odontologistIDao.get(id);
    }

    public List<Odontologist> getAll() {
        return odontologistIDao.getAll();
    }

    public  Odontologist setOdontologist(Odontologist odontologist){
        return odontologistIDao.set(odontologist);
    }

    public Odontologist updateOdontologist(Odontologist odontologist){
        return odontologistIDao.update(odontologist);
    }

    public void delete(Long id){
        odontologistIDao.delete(id);
    }
}
