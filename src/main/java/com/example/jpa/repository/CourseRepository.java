package com.example.jpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);		
	}
	
	public Course save(Course course) {
		if(course.getId()==null)
			em.persist(course);
		else
			em.merge(course);
		
		return course;
	}
	
	public void deleteById(Long id) {
		Course course=findById(id);
		em.remove(course);
	}
	
	

}
