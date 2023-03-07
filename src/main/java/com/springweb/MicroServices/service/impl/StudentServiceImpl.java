package com.springweb.MicroServices.service.impl;

import com.springweb.MicroServices.model.Student;
import com.springweb.MicroServices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {



    Set<Student> studentList = new HashSet<>();

    @Override
    public Student getSearch(String studentNumber) {
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
    public Set<Student> getStudentByRollNumber(String rollNo) {
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

        return studentList.stream().filter(s -> Objects.nonNull(s.getRollNumber()) && s.getRollNumber().equalsIgnoreCase(rollNo)).collect(Collectors.toSet());
    }

    @Override
    public String saveStudent(Student student) {
        if(validateStudents(student)) {
            studentList.add(student);
            return "Student record saved successfully";
        }else{
            return "Mandatory fields are missing in input request studentNumber and RollNumber";
        }
    }

    private boolean validateStudents(Student student) {
        return Objects.nonNull(student.getStudentNumber()) && Objects.nonNull(student.getRollNumber());
    }

    @Override
    public String updateStudent(Student student) {
        if(validateStudents(student)){
            Optional<Student> st = studentList.stream().filter(s-> s.getStudentNumber().equalsIgnoreCase(student.getStudentNumber())).findFirst();
            if(st.isPresent()){
                st.get().setStudentNumber(student.getStudentNumber());
                st.get().setStudentClass(student.getStudentClass());
                st.get().setStudentName(student.getStudentName());
                st.get().setRollNumber(student.getRollNumber());
                studentList.add(st.get());
                return "updated successfully";
            }else{
                return "provided student not found in DB";
            }
        }
        return "Mandatory fields are missing";
    }
}
