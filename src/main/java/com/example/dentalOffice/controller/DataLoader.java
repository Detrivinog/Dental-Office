package com.example.dentalOffice.controller;

import com.example.dentalOffice.entity.Rol;
import com.example.dentalOffice.entity.User;
import com.example.dentalOffice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("Diego", "david@dental.com", "1234", Rol.ADMIN));
        userRepository.save(new User("Paula", "paula@digital.com", "123", Rol.USER));
    }
}
