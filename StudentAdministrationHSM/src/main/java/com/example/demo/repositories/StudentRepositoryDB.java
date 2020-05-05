package com.example.demo.repositories;

import com.example.demo.models.Student;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryDB implements IStudentRepository {

    private Connection conn;

    public StudentRepositoryDB() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createStudent(Student student) {

        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO student values (?,?,?,?)");
            stmnt.setInt(1,student.getCpr());
            stmnt.setString(2,student.getFirstName());
            stmnt.setString(3,student.getLastName());
            stmnt.setString(4,student.getStartDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> readAllStudents(){
        try {
            PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM student");
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
