package com.learn.dao;

import com.learn.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void save(StudentEntity studentEntity);

    StudentEntity findById(int id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByLastName(String lastName);

    void updateStudent(StudentEntity studentEntity);

    void deleteStudent(int id);
}
