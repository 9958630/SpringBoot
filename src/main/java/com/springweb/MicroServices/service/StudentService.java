package com.springweb.MicroServices.service;

import com.springweb.MicroServices.model.Student;

import java.util.List;

public interface StudentService {

    public Student getSearch(String studentNumber);

    List<Student> getStudentByRollNumber(String rollNumber);
}
