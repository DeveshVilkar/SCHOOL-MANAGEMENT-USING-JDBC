package com.school.service;

import com.school.dao.TeacherDao;
import com.school.dto.Teacher;

public class TeacherService {
    TeacherDao teacherDao=new TeacherDao();
    public Teacher serviceProvider(Teacher teacher){
        Teacher t=teacherDao.saveTeacher(teacher);
        return t;
    }
    public boolean deleteData(int id){
        return teacherDao.deleteData(id);
    }
    public boolean updateData(int id,String name,String sub){
        return teacherDao.updateData(id, name, sub);
    }
    public boolean selectSingleData(int id){
        return teacherDao.selectSingleData(id);
    }
    public boolean selectAll(String table_name){
        return teacherDao.selectAll(table_name);
    }
}
