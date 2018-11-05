package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void finById() {
        Student student = studentRepository.finById(20001L);
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
        Student student = studentRepository.finById(20001L);
        assertNull(student);
    }

}
