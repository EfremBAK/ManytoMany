package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseid;

    @Column(name = "coursename")
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public Course() {
    }

    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy ="courses")
    private Set<Student> students;

    public   Set<Student>  getStudent(){
        return students;
    }
    public void setStudents(Set<Student> students){
        this.students = students;
    }
 }
