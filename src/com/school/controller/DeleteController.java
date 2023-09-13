package com.school.controller;

import com.school.service.StudentService;

public class DeleteController {
    public static void main(String[] args) {
        StudentService studentService=new StudentService();
        boolean rs=studentService.deleteStudent(1);
        System.out.println(rs);
    }
}
