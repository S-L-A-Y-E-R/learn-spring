package com.learn.dao;

import com.learn.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// Marking the class as a valid spring component
@Repository
public class StudentDAOImplementation implements StudentDAO{
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    // Performs auto begin and commit transaction
    @Transactional
    public void save(StudentEntity studentEntity) {
        entityManager.persist(studentEntity);
    }

    @Override
    public StudentEntity findById( int id) {
        return entityManager.find(StudentEntity.class,id);
    }

    @Override
    public List<StudentEntity> findAll() {
        TypedQuery<StudentEntity> query = entityManager.createQuery("from StudentEntity",StudentEntity.class);
        return query.getResultList();
    }

    @Override
    public List<StudentEntity> findByLastName(String lastName) {
        TypedQuery<StudentEntity> query = entityManager.createQuery("from StudentEntity where last_name = :lName",StudentEntity.class);
        query.setParameter("lName",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(StudentEntity studentEntity) {
        entityManager.merge(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class,id);
        entityManager.remove(studentEntity);
    }
}
