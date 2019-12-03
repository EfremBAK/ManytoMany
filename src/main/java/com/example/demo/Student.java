package com.example.demo;

import com.example.demo.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private Set<Course> courses = new HashSet<Course>(0);


    public Student() {
    }

    public Student(long id, String firstName, String lastName, String department, String email, Set<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "student_course", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "courseid")})
    public Set<Course> getCourses() {
        return this.courses;
    }



    public boolean hasCourse(Course course) {
        for (Course studentCourse: getCourses()) {
            if (studentCourse.getCourseid() == course.getCourseid()) {
                return true;
            }
        }
        return false;
    }


}