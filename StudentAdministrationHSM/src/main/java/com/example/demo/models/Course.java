package com.example.demo.models;

public class Course {
    private String courseName;
    private String startDate;
    private String courseDescription;
    private double etcs;

    public Course(String courseName, String startDate, String courseDescription, double etcs) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.courseDescription = courseDescription;
        this.etcs = etcs;
    }
    public Course(){

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public double getEtcs() {
        return etcs;
    }

    public void setEtcs(double etcs) {
        this.etcs = etcs;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", etcs=" + etcs +
                '}';
    }
}
