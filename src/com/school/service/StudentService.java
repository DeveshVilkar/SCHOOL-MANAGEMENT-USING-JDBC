package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {
    StudentDao studentdao=new StudentDao();
    public Student savestudent(Student student){
        return studentdao.saveStudent(student);
    }
    public boolean deleteStudent(int id) {
        return studentdao.deleteStudent(id);
    }
    public boolean updateStudent(String name,String email,int id) {
        return studentdao.updateStudent(name, email, id);
    }
    public boolean selectSingleData(int id){
        return studentdao.selectSingleData(id);

    }
    public boolean selectAll(String tablename){
        return studentdao.selectAll(tablename);
    }
}
