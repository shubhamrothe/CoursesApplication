package com.example.CourseApplication.services;

import java.util.List;

import com.example.CourseApplication.entities.Course;

public interface CourseServiceI {

	public List<Course> getCourses();
	
	public Course getCourseById(long courseId);

	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
}
