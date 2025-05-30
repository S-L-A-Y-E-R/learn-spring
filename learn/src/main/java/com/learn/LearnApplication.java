package com.learn;

import com.learn.dao.StudentDAO;
import com.learn.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{

        };
    }

    public static void createStudent(StudentDAO studentDAO){
        StudentEntity studentEntity = new StudentEntity("ahmed@mail.com","Ahmed","Ashraf");
        studentDAO.save(studentEntity);
    }

    public static void findStudent(StudentDAO studentDAO,int id){
        System.out.println(studentDAO.findById(id));
    }

    public static void findAllStudents(StudentDAO studentDAO){
        System.out.println(studentDAO.findAll());
    }

    public static void findByLastName(StudentDAO studentDAO,String lastName){
        System.out.println(studentDAO.findByLastName(lastName));
    }

    public static void updateStudentFirstName(StudentDAO studentDAO,int id,String newFirstName){
        StudentEntity studentEntity = studentDAO.findById(id);
        studentEntity.setFirst_name(newFirstName);
        studentDAO.updateStudent(studentEntity);
    }

    public static void deleteStudent(StudentDAO studentDAO,int id){
        studentDAO.deleteStudent(id);
    }

}
