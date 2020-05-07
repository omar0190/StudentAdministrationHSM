package com.example.studentadministrationsystem.repositories;

import com.example.studentadministrationsystem.models.Student;
import com.example.studentadministrationsystem.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryDB implements IStudentRepository {

    private Connection conn;

    public StudentRepositoryDB() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createStudent(Student student) {

        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO students values (?,?,?,?)");
            stmnt.setString(1,student.getCpr());
            stmnt.setString(2,student.getFirstName());
            stmnt.setString(3,student.getLastName());
            stmnt.setString(4,student.getStartDate());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> readAllStudents(){
        List <Student> studentList = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student student = new Student();
                student.setCpr(rs.getString(1));
                student.setFirstName(rs.getNString(2));
                student.setLastName(rs.getNString(3));
                student.setStartDate(rs.getString(4));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return studentList;
    }

    @Override
    public Student readStudent(String cpr) {
        Student student = new Student();
        try {
            PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM students where cpr =?");
            stmnt.setString(1,cpr);
            ResultSet rs = stmnt.executeQuery();

            while (rs.next()){
                student.setCpr(rs.getString(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setStartDate(rs.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return student;

    }

    @Override
    public boolean editStudent(Student student) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE students SET cpr=?, firstName=?, lastName=?, startDate=?");
            stmnt.setString(1,student.getCpr());
            stmnt.setString(2,student.getFirstName());
            stmnt.setString(3,student.getLastName());
            stmnt.setString(4,student.getStartDate());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String cpr) {
        PreparedStatement stmnt = null;
        try {
            stmnt = conn.prepareStatement("DELETE FROM students WHERE cpr=?");
            stmnt.setString(1, cpr);
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }

