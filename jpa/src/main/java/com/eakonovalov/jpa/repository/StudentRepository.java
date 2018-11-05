package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    public Student finById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if(student.getId() == null) {
            em.persist(student);
        }
        else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = finById(id);
        em.remove(student);
    }

}
