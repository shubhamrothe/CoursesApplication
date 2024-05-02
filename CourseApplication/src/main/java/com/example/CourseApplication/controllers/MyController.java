package com.example.CourseApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApplication.entities.Course;
import com.example.CourseApplication.services.CourseServiceI;

@RestController
public class MyController {
	@Autowired
	private CourseServiceI courseServiceI;
	
	//Get All Courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseServiceI.getCourses();	
	}
	
	//Get Course by Id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return courseServiceI.getCourseById(Long.parseLong(courseId));
	}
	
	//Add Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return courseServiceI.addCourse(course);
	}
	
	//Update Course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseServiceI.updateCourse(course);
	}
	
	//Delete Course by Id
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
		this.courseServiceI.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
