package com.klu.model;

public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // setter injection
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("ID=" + studentId +
                ", Name=" + name +
                ", Course=" + course +
                ", Year=" + year);
    }
}
