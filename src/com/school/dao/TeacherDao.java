package com.school.dao;

import com.school.configuration.HelperClass;
import com.school.dto.Teacher;

import java.sql.*;

public class TeacherDao {
    Connection connection=null;
    HelperClass helperclass=new HelperClass();
    public Teacher saveTeacher(Teacher teacher){
        connection=helperclass.makeConncection();
        try {
            PreparedStatement prepareStatement =connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?)");
            prepareStatement.setInt(1,teacher.getId());
            prepareStatement.setString(2, teacher.getName());
            prepareStatement.setString(3, teacher.getSubject());

            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return teacher;
    }
//    to delete data
    public boolean deleteData(int id)  {
       connection= helperclass.makeConncection();
        try {
            PreparedStatement ps=connection.prepareStatement("DELETE FROM teacher WHERE id=?");
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
//    to update data
    public boolean updateData(int id,String name,String sub) {
        connection=helperclass.makeConncection();
        try {
            PreparedStatement ps=connection.prepareStatement("UPDATE teacher SET name=? ,subject=? WHERE id=?");
            ps.setString(1,name);
            ps.setString(2,sub);
            ps.setInt(3,id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
//    to select single data
    public boolean selectSingleData(int id){
        connection=helperclass.makeConncection();
        try {
           PreparedStatement ps= connection.prepareStatement("SELECT * FROM teacher WHERE id=?");
           ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println("Id ="+rs.getInt(1));
                System.out.println("Name ="+rs.getString(2));
                System.out.println("Subject ="+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
       return true;
    }
//    to select all data
    public boolean selectAll(String table_name){
        connection=helperclass.makeConncection();
        String sql="select * from "+table_name;
        try {
            Statement statement =connection.createStatement();
           ResultSet resultSet= statement.executeQuery(sql);
           while(resultSet.next()){
               System.out.println(resultSet.getInt(1));
               System.out.println(resultSet.getString(2));
               System.out.println(resultSet.getString(3));
               System.out.println("========================");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
