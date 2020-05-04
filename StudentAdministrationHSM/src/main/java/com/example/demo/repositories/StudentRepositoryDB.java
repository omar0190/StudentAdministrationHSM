package com.example.demo.repositories;

import com.example.demo.models.Student;

import java.util.List;

public class StudentRepositoryDB implements IStudentRepository {
    @Override
    public void createStudent(Student student) {

    }

    @Override
    public List<Student> readAllStudents() {
        return null;
    }

    @Override
    public Student readStudent(int cpr) {
        return null;
    }

    @Override
    public boolean editStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(int cpr) {
        return false;
    }
}
