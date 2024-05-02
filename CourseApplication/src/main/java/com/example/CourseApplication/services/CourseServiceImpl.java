package com.example.CourseApplication.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApplication.entities.Course;
import com.example.CourseApplication.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseServiceI {

	@Autowired
	private CourseRepository courseRepository;
	//List<Course> list;
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(14, "Java Core", "This course contains all concepts of core java"));
//		list.add(new Course(123,"Spring Boot","This course contains all concepts of spring boot"));
	
	}
	
	//get all courses
	@Override
	public List<Course> getCourses() {

		//return list;
		return courseRepository.findAll();
		}

	//get course by id
	@Override
	public Course getCourseById(long courseId) {
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()== courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		
		return courseRepository.getOne(courseId);
	}

	//add course
	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		//return course;
		courseRepository.save(course);
		return course;
	}

	//update course
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e->{
//			if(e.getId()== course.getId()){
//				//e.setId(course.getId());
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				}
//		});
//		return course;
		
		courseRepository.save(course);
		return course;
	}

	//delete course
	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
		//list= this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = courseRepository.getOne(parseLong);
		courseRepository.delete(entity);
	}

}
