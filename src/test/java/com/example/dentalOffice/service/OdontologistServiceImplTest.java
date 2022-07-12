package com.example.dentalOffice.service;

import com.example.dentalOffice.entity.dto.OdontologistDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologistServiceImplTest {

    @Autowired
    private OdontologistServiceImpl odontologistService;

    @Test
    public void testSaveOdontologist(){
        OdontologistDto o = new OdontologistDto();
        o.setLastname("Rios");
        o.setName("Diego");
        odontologistService.saveOdontologist(o);

        Set<OdontologistDto> os = odontologistService.getAllOdontologist();
        boolean result = os.size() > 0;

        assertTrue(result);
    }

}