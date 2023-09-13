package com.school.controller;

import com.school.service.StudentService;

public class SingleDataFetch {
    public static void main(String[] args) {
        StudentService studentService=new StudentService();
       boolean res=studentService.selectSingleData(6);
        System.out.println(res);
    }
}
