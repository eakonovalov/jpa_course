package com.eakonovalov.jpa.repository;

import com.eakonovalov.jpa.entity.Course;
import com.eakonovalov.jpa.entity.Review;
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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void finById() {
        Course course = courseRepository.findById(10001L);
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
        Course course = courseRepository.findById(10001L);
        assertNull(course);
    }

    @Test
    @Transactional
    public void retrieveCourseWithReviews() {
        Course course = courseRepository.findById(10001L);
        List<Review> reviews = course.getReviews();
        log.info("Reviews size -> {}", reviews.size());
    }

    @Test
    public void retrieveReviewWithCourse() {
        Review review = em.find(Review.class, 30001L);
        Course course = review.getCourse();
        log.info("Course -> {}", course.getName());
    }

}
