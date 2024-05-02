package com.example.CourseApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseApplication.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
