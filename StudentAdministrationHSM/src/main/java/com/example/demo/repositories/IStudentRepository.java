package com.example.demo.repositories;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentRepository {
    public void createStudent(Student student);


    public List<Student> readAllStudents();


    public Student readStudent(int cpr);

    public boolean editStudent(Student student);

    public boolean deleteStudent(int cpr);
}


