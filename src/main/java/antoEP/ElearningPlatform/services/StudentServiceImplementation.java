package antoEP.ElearningPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antoEP.ElearningPlatform.entities.Course;
import antoEP.ElearningPlatform.repositories.CourseRepository;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> fetchCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public Course fetchCourse(int courseId) {
        return courseRepository.findByCourseId(courseId);
    }
}
