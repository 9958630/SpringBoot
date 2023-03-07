package com.springweb.MicroServices.controller;

import com.springweb.MicroServices.model.Student;
import com.springweb.MicroServices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    public Set<Student> getStudentList(@RequestParam("rollNo")String rollNo){
        System.out.println("Student roll No :"+rollNo);
        Set<Student> studentList = studentService.getStudentByRollNumber(rollNo);
        if(!CollectionUtils.isEmpty(studentList)){
            return studentList;
        }
        return studentList;
    }
/*
    @GetMapping("/getStudentByRollNumber")
    public List<Student> getStudentListwithStudentNo(@RequestParam("rollNo")String rollNo,@RequestParam("studentNo") String studentNo){
        System.out.println("Student roll No :"+rollNo);
        List<Student> studentList = studentService.getStudentByRollNumber(rollNo);
        if(!CollectionUtils.isEmpty(studentList)){
            return studentList;
        }
        return studentList;
    }*/

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        if(Objects.nonNull(student)){
            return studentService.saveStudent(student);

        }else{
            return "Input request is empty please privide input request...!!";
        }

    }


    @PatchMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){
        if(Objects.nonNull(student)){
            return studentService.updateStudent(student);
        }
        return "Input request is empty please provide input request...!!";
    }
}
