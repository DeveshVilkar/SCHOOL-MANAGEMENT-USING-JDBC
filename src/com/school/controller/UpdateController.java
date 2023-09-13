package com.school.controller;

import com.school.service.StudentService;

public class UpdateController {
    public static void main(String[] args) {
        StudentService studentService=new StudentService();
        boolean sr=studentService.updateStudent("rahul", "rahul@mail.com", 1);
        System.out.println(sr);
    }
}
