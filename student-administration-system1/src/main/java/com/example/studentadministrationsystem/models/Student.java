package com.example.studentadministrationsystem.models;

public class Student {

    private String firstName;
    private String lastName;
    private String startDate;
    private int cpr;

    public Student(String firstName, String lastName, String startDate, int cpr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.cpr = cpr;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", cpr=" + cpr +
                '}';
    }
}
