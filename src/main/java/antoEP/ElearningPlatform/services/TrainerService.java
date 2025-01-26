package antoEP.ElearningPlatform.services;

import java.util.List;

import antoEP.ElearningPlatform.entities.Course;

public interface TrainerService {
    String addCourse(Course course);
    List<Course> fetchAllCourses();
    String saveCourse(Course course);
    void deleteCourse(int courseId); // Deletes a course 
}
