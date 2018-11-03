package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CourseRepository {

    @PersistenceContext
    private EntityManager em;

    public Course finById(Long id) {
        return em.find(Course.class, id);
    }

}
