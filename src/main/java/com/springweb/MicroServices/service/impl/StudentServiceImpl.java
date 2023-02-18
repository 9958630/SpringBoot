package com.springweb.MicroServices.service.impl;

import com.springweb.MicroServices.model.Student;
import com.springweb.MicroServices.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Student getSearch(String studentNumber) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setStudentName("Bala");
        student.setStudentNumber("1234");
        student.setStudentClass("2nd class");
        studentList.add(student);

        Student student1 = new Student();
        student1.setStudentName("Kitti");
        student1.setStudentNumber("9999");
        student1.setStudentClass("10th class");
        studentList.add(student1);

        Student student2 = new Student();
        student2.setStudentName("Santosh");
        student2.setStudentNumber("8888");
        student2.setStudentClass("12th class");
        studentList.add(student2);

        Student student3 = new Student();
        student3.setStudentName("Ravi");
        student3.setStudentNumber("8888");
        student3.setStudentClass("9th class");
        studentList.add(student3);
        /*for(Student s : studentList){
            if(s.getStudentNumber().equalsIgnoreCase(studentNumber)){
                return s;
            }
        }*/

        Optional<Student> result = studentList.stream().filter(s -> s.getStudentNumber().equalsIgnoreCase(studentNumber)).findAny();

        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }



    }

    @Override
    public List<Student> getStudentByRollNumber(String rollNo) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setRollNumber("1");
        student.setStudentClass("1st class");
        student.setStudentName("balu");
        student.setStudentNumber("3432");

        Student student1 = new Student();
        student1.setRollNumber("1");
        student1.setStudentClass("2nd class");
        student1.setStudentName("Ravi");
        student1.setStudentNumber("3432");

        Student student2 = new Student();
        student2.setRollNumber("2");
        student2.setStudentClass("3rd class");
        student2.setStudentName("kumar");
        student2.setStudentNumber("3432");

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);

        return studentList.stream().filter(s -> s.getRollNumber().equalsIgnoreCase(rollNo)).collect(Collectors.toList());
    }
}
