package com.example.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Review;
import com.example.jpa.entity.Student;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	studentRepository.saveStudentWithPassport();
	//	List<Review> reviews=new ArrayList<>();
	//	reviews.add(new Review("5","Great hands-on"));
	//	reviews.add(new Review("5","Hatts off"));
	//	courseRepository.addReviewForCourse(10003L,reviews);
	//	studentRepository.insertStudentAndCourse();
		studentRepository.insertStudentAndCourse(new Student("Jack"),new Course("microservies"));
		// TODO Auto-generated method stub
		
	}

}
