package com.school.controller;

import com.school.dto.Student;
import com.school.dto.Teacher;
import com.school.service.StudentService;
import com.school.service.TeacherService;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Student student=new Student();
        Teacher teacher=new Teacher();
        StudentService studentService=new StudentService();
        TeacherService teacherservice=new TeacherService();
        Scanner sc=new Scanner(System.in);
       boolean flag=true;
        while (flag){
            System.out.println("1.to insert value in table 2.to delete value 3.to update value 4.to select single value 5.to select all the data 6.exit");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1.to insert data in student table 2.to insert data in teacher table");
                    int choice1=sc.nextInt();
                    switch(choice1){
                        case 1:
                            //                    for student table
                            System.out.println("enter the id :");
                            int id=sc.nextInt();
                            student.setId(id);
                            System.out.println("enter the name :");
                            String name=sc.next();
                            student.setName(name);
                            System.out.println("enter the email :");
                            String email= sc.next();
                            student.setEmail(email);

                            Student s=studentService.savestudent(student);

                            if (s!=null){
                                System.out.println("inserted student successfully");
                            }
                            break;
                        case 2:
                            //                    for teacher
                            System.out.println("enter the id :");
                            int teacherid=sc.nextInt();
                            teacher.setId(teacherid);
                            System.out.println("enter the name :");
                            String teachername=sc.next();
                            teacher.setName(teachername);
                            System.out.println("enter the subject :");
                            String teachersubject= sc.next();
                            teacher.setSubject(teachersubject);

                            Teacher t=teacherservice.serviceProvider(teacher);

                            if (t!=null){
                                System.out.println("inserted teacher data");
                            }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("1.to delete data from student table 2.to delete data from teacher table");
                    int choice2=sc.nextInt();
                    switch(choice2){
                        case 1:
                            System.out.println("enter the id to delete the data");
                            int delid=sc.nextInt();
                            boolean r= studentService.deleteStudent(delid);
                            if(r==true){
                                System.out.println("deleted successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the id to delete the data");
                            int tid= sc.nextInt();
                            boolean r1= teacherservice.deleteData(tid);
                            if(r1==true){
                                System.out.println("deleted successfully");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1.to update data from student table 2.to update data from teacher table");
                    int choice3=sc.nextInt();
                    switch(choice3){
                        case 1:
                            System.out.println("enter the id which data needs to be updated");
                            int num=sc.nextInt();
                            System.out.println("enter the name:");
                            String n=sc.next();
                            System.out.println("enter the email:");
                            String e=sc.next();
                            boolean res=studentService.updateStudent(n,e,num);
                            if (res==true){
                                System.out.println("updated successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the id which data needs to be updated");
                            int tnum=sc.nextInt();
                            System.out.println("enter the name:");
                            String tn=sc.next();
                            System.out.println("enter the subject:");
                            String ts=sc.next();
                            boolean teres=teacherservice.updateData(tnum,tn,ts);
                            if (teres==true){
                                System.out.println("updated successfully");
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1.to select single data from student table 2.to select single data from teacher table");
                    int choice4=sc.nextInt();
                    switch(choice4){
                        case 1:
                            System.out.println("enter the id which data to be fetch");
                            int number=sc.nextInt();
                            boolean result=studentService.selectSingleData(number);
                            if (result==true){
                                System.out.println("fetched successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the id which data to be fetch");
                            int tnumber=sc.nextInt();
                            boolean tearesult=teacherservice.selectSingleData(tnumber);
                            if (tearesult==true){
                                System.out.println("fetched successfully");
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("1.to select all data from student table 2.to select all data from teacher table");
                    int choice5=sc.nextInt();
                    switch(choice5){
                        case 1:
                            System.out.println("enter the table name whose data to be fetched ");
                            String tablename=sc.next();
                            boolean result1=studentService.selectAll(tablename);
                            if (result1==true){
                                System.out.println("fetched all successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the table name whose data to be fetched ");
                            String teatablename=sc.next();
                            boolean tearesult1=teacherservice.selectAll(teatablename);
                            if (tearesult1==true){
                                System.out.println("fetched all successfully");
                            }
                            break;
                    }
                    break;
                case 6:
                    flag=false;
                    break;
                default:
                    System.out.println("wrong input");
            }
        }
    }
}
