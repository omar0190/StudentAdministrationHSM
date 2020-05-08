package com.example.studentadministrationsystem.repositories;

import com.example.studentadministrationsystem.models.Course;
import com.example.studentadministrationsystem.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryDB implements ICourseRepository {

    private Connection conn;

    public CourseRepositoryDB (){

        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createCourse(Course course) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO courses(courseName, startDate, CourseDescription, etcs) values (?,?,?,?)");
            stmnt.setString(1,course.getCourseName());
            stmnt.setString(2,course.getStartDate());
            stmnt.setString(3,course.getCourseDescription());
            stmnt.setDouble(4,course.getEtcs());

            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Course> readAllCourses() {
        List <Course> courseList = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setStartDate(rs.getString(3));
                course.setCourseDescription(rs.getString(4));
                course.setEtcs(rs.getDouble(5));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public Course readCourses(int courseID) {

        Course course = new Course();
        try {
            PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM courses where courseID =?");
            stmnt.setInt(1,courseID);
            ResultSet rs = stmnt.executeQuery();

            while (rs.next()){
                course.setCourseID(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setStartDate(rs.getString(3));
                course.setCourseDescription(rs.getString(4));
                course.setEtcs(rs.getDouble(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public boolean editCourse(Course course) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE courses SET courseName=?, startDate=?, courseDescription=?, etcs=?");

            stmnt.setString(1,course.getCourseName());
            stmnt.setString(2,course.getStartDate());
            stmnt.setString(3,course.getCourseDescription());
            stmnt.setDouble(4,course.getEtcs());

            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteCourse(int courseID) {
        PreparedStatement stmnt = null;
        try {
            stmnt = conn.prepareStatement("DELETE FROM courses WHERE courseID=?");
            stmnt.setInt(1, courseID);
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}


