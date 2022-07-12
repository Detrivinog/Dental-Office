package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Rol;
import com.example.dentalOffice.entity.User;
import com.example.dentalOffice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User(1L,"Diego", "david@dental.com", "1234", Rol.ADMIN));
        userRepository.save(new User(2L,"Paula", "paula@digital.com", "123", Rol.USER));
    }
}
