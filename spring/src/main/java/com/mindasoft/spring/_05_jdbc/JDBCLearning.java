package com.mindasoft.spring._05_jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: min
 * @date: 2019/4/11 15:06
 * @version: 1.0.0
 */
public class JDBCLearning{

        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-beans.xml");
            StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
            System.out.println("------Records Creation--------");
            studentJDBCTemplate.create("Zara", 11);
            studentJDBCTemplate.create("Nuha", 2);
            studentJDBCTemplate.create("Ayan", 15);
            System.out.println("------Listing Multiple Records--------");
            List<Student> students = studentJDBCTemplate.listStudents();
            for (Student record : students) {
                System.out.print("ID : " + record.getId());
                System.out.print(", Name : " + record.getName());
                System.out.println(", Age : " + record.getAge());
            }
            System.out.println("----Updating Record with ID = 2 -----");
            studentJDBCTemplate.update(2, 20);
            System.out.println("----Listing Record with ID = 2 -----");
            Student student = studentJDBCTemplate.getStudent(2);
            System.out.print("ID : " + student.getId());
            System.out.print(", Name : " + student.getName());
            System.out.println(", Age : " + student.getAge());
        }
}