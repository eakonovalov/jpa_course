package com.eakonovalov.jpa;

import com.eakonovalov.jpa.entity.Course;
import com.eakonovalov.jpa.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void contextLoads() {
        Course c = courseRepository.finById(10001L);
        assertEquals("Math", c.getName());
    }

}
