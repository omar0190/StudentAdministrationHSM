package com.example.studentadministrationsystem.repositories;

import com.example.studentadministrationsystem.models.Student;

import java.util.List;

public interface IStudentRepository {
    public void createStudent(Student student);


    public List<Student> readAllStudents();


    public Student readStudent(String cpr);

    public boolean editStudent(Student student);

    public boolean deleteStudent(String cpr);
}
