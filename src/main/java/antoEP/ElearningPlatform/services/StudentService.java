package antoEP.ElearningPlatform.services;

import java.util.List;

import antoEP.ElearningPlatform.entities.Course;

public interface StudentService {
    List<Course> fetchCourseList(); // Fetch the list of all courses
    Course fetchCourse(int courseId); // Fetch a course by its ID
}
