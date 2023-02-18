package com.springweb.MicroServices.controller;

import com.springweb.MicroServices.model.Student;
import com.springweb.MicroServices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentDetails")
    public Student getStudentDetails(@RequestParam("StudentNo") String studentNo){
        System.out.println("Student Number : "+studentNo);
        Student student = studentService.getSearch(studentNo);
        if(Objects.isNull(student)){
            System.out.println("StudentNumber not found in our records");
        }
        return student;
    }

    @GetMapping("/getStudentByRollNumber")
    public List<Student> getStudentList(@RequestParam("rollNo")String rollNo){
        System.out.println("Student roll No :"+rollNo);
        List<Student> studentList = studentService.getStudentByRollNumber(rollNo);
        if(!CollectionUtils.isEmpty(studentList)){
            return studentList;
        }
        return studentList;
    }
}
