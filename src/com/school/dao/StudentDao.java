package com.school.dao;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

import java.sql.*;

public class StudentDao {
    HelperClass helperclass=new HelperClass();
    Connection connection=null;


//    to select all the records
    public boolean selectAll(String tablename){
        String sql="SELECT * FROM "+tablename;
        connection=helperclass.makeConncection();
        try {
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID = "+rs.getInt(1));
                System.out.println("NAME = "+rs.getString(2));
                System.out.println("EMAIL = "+rs.getString(3));
                System.out.println("===============");
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
//    to select single records
    public boolean selectSingleData(int id) {
        connection = helperclass.makeConncection();
        try {
            PreparedStatement preparedstatement=connection.prepareStatement("SELECT * FROM student WHERE id=?");
            preparedstatement.setInt(1,id);
            ResultSet rs =preparedstatement.executeQuery();
            while(rs.next()){
                System.out.println("ID = "+rs.getInt(1));
                System.out.println("NAME = "+rs.getString(2));
                System.out.println("EMAIL = "+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;

    }

    //	to update student data
    public boolean updateStudent(String name,String email,int id) {
        connection=helperclass.makeConncection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE student SET name=?,email=? WHERE id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

    //	to delete student data
    public boolean deleteStudent(int id) {
        connection=helperclass.makeConncection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM student WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (id!=0) {
                return true;
            }else {
                return false;
            }
        }

    }
    public Student saveStudent(Student student){
        connection=helperclass.makeConncection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO student VALUES(?,?,?)");
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getEmail());

            preparedStatement.execute();

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
        return student;

    }
}
