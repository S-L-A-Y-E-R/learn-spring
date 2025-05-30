package com.learn.dao;

import com.learn.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void save(StudentEntity studentEntity);

    StudentEntity findById(int id);

    List<StudentEntity> findAll();
}
