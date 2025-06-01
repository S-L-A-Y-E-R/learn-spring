package com.learn.rest;


import com.learn.dao.StudentDAOImplementation;
import com.learn.entity.StudentEntity;
import com.learn.exception.StudentNotFoundException;
import com.learn.pojo.StudentPOJO;
import com.learn.pojo.StudentResponseError;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentDAOImplementation studentDAOImplementation;
    List<StudentEntity> students = new ArrayList<>();

    @Autowired
    public StudentController(StudentDAOImplementation studentDAOImplementation) {
        this.studentDAOImplementation = studentDAOImplementation;
    }

    //    @PostConstruct
//    public void loadData()
//    {
//        students.add(new StudentPOJO(1,"Ahmed","Ashraf"));
//        students.add(new StudentPOJO(2,"Omar","Mohamed"));
//        students.add(new StudentPOJO(3,"Salah","Ibrahim"));
//    }

    @GetMapping("/students")
    public List<StudentEntity> getStudents(){
        return studentDAOImplementation.findAll();
    }

    @GetMapping("/students/{studentId}")
    public StudentEntity getStudent(@PathVariable int studentId){
        if(studentId<0 || studentId > students.size()){
            throw new StudentNotFoundException("Student with id : "+studentId+ " not found");
        }

        return studentDAOImplementation.findById(studentId);
    }
}
