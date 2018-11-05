package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void finById() {
        Course course = courseRepository.finById(10001L);
        assertEquals("Math", course.getName());
    }

    @Test
    @DirtiesContext
    public void save() {
        Course course = new Course("Programming");
        courseRepository.save(course);
        assertNotNull(course.getId());
    }

    @Test
    @DirtiesContext
    public void delete() {
        courseRepository.deleteById(10001L);
        Course course = courseRepository.finById(10001L);
        assertNull(course);
    }

}
