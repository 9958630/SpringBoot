package com.springweb.MicroServices.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Student {

    private String studentName;
    private String studentNumber;
    private String studentClass;
    private String rollNumber;
}
