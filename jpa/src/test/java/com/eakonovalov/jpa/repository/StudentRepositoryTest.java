package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Passport;
import com.eakonovalov.jpa.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void finById() {
        Student student = studentRepository.findById(20001L);
        assertEquals("John", student.getName());
        assertEquals("J123456", student.getPassport().getNumber());
    }

    @Test
    @DirtiesContext
    public void save() {
        Student student = new Student("John");
        studentRepository.save(student);
        assertNotNull(student.getId());
    }

    @Test
    @DirtiesContext
    public void delete() {
        studentRepository.deleteById(20001L);
        Student student = studentRepository.findById(20001L);
        assertNull(student);
    }

    @Test
    @Transactional
    public void retrieveStudentWithPassport() {
        Student student = studentRepository.findById(20001L);
        Passport passport = student.getPassport();
        log.info("Passport -> {}", passport);
    }

    @Test
    public void retrievePassportWithStudent() {
        Passport passport = em.find(Passport.class, 30001L);
        Student student = passport.getStudent();
        log.info("Student -> {}", student);
    }

}
