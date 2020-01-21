package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Review;

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
	
	public void addReviewForCourse() {
		Course course=findById(10003L);
		Review review1 =new Review("5","Great handson stuff");
		Review review2 =new Review("5","Hatsoff");
		course.addReviews(review1);
		review1.setCourse(course);
		
		course.addReviews(review2);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewForCourse(Long courseId,List<Review> reviews) {
		Course course=findById(courseId);
		
		for(Review review:reviews) {
		
		course.addReviews(review);
		review.setCourse(course);
		
		em.persist(review);
	
		}
	}
	
	

}
