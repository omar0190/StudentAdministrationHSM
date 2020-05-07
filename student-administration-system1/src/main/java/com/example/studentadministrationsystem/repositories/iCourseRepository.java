package com.example.studentadministrationsystem.repositories;

import com.example.studentadministrationsystem.models.Course;
import com.example.studentadministrationsystem.models.Student;
import com.example.studentadministrationsystem.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.List;

public interface iCourseRepository {



        public void createRepository (Course course);


        public List<Course> readAllCourses();


        public Course readCourses(int courseID);

        public boolean editCourse(Course course);

        public boolean deleteCourse(int courseID);
    }

