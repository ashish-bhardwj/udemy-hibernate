package com.example.jpa;

import org.h2.command.CommandInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.saveStudentWithPassport();
		// TODO Auto-generated method stub
		
	}

}
