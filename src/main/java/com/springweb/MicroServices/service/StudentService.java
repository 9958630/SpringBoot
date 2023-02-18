package com.springweb.MicroServices.service;

import com.springweb.MicroServices.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {

    public Student getSearch(String studentNumber);

    Set<Student> getStudentByRollNumber(String rollNumber);

    String saveStudent(Student student);

    String updateStudent(Student student);
}
