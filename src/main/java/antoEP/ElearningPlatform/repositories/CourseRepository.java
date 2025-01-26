package antoEP.ElearningPlatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import antoEP.ElearningPlatform.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // Custom query to find a course by its ID
    Course findByCourseId(int courseId);

    // The deleteById(Integer id) method is already provided by JpaRepository
}
