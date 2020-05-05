package com.example.studentadministrationsystem.repositories;

import com.example.studentadministrationsystem.models.Student;

import java.util.List;

public interface IStudentRepository {
    public void createStudent(Student student);


    public List<Student> readAllStudents();


    public Student readStudent(int cpr);

    public boolean editStudent(Student student);

    public boolean deleteStudent(int cpr);
}
