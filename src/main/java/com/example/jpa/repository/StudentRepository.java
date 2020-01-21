package com.example.jpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Passport;
import com.example.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);		
	}
	
	public Student save(Student student) {
		if(student.getId()==null)
			em.persist(student);
		else
			em.merge(student);
		
		return student;
	}
	
	public void deleteById(Long id) {
		Student student=findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport=new Passport("E1239");
		em.persist(passport);
		Student student=new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
		
	}
	
	public void insertStudentAndCourse() {
		Student student=new Student("Jack");
		Course course=new Course("microservices");
		em.persist(student);
		em.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student,Course course) {
		em.persist(student);
		em.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		
		//em.persist(student);
	}

}
