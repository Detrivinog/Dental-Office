package com.example.dentalOffice;

import com.example.dentalOffice.entity.Rol;
import com.example.dentalOffice.entity.User;
import com.example.dentalOffice.repository.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentalOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalOfficeApplication.class, args);
	}

}
