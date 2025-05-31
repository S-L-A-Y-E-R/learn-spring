package com.learn.rest;


import com.learn.exception.StudentNotFoundException;
import com.learn.pojo.StudentPOJO;
import com.learn.pojo.StudentResponseError;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<StudentPOJO> students = new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        students.add(new StudentPOJO(1,"Ahmed","Ashraf"));
        students.add(new StudentPOJO(2,"Omar","Mohamed"));
        students.add(new StudentPOJO(3,"Salah","Ibrahim"));
    }

    @GetMapping("/students")
    public List<StudentPOJO> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public StudentPOJO getStudent(@PathVariable int studentId){
        if(studentId<0 || studentId > students.size()){
            throw new StudentNotFoundException("Student with id : "+studentId+ " not found");
        }

        return students.stream()
                .filter(studentPOJO -> studentPOJO.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    @ExceptionHandler
    public ResponseEntity<StudentResponseError> handleException(StudentNotFoundException exception){
        StudentResponseError error = new StudentResponseError();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
