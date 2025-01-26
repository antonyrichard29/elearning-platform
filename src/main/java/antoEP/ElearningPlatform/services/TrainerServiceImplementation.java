package antoEP.ElearningPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antoEP.ElearningPlatform.entities.Course;
import antoEP.ElearningPlatform.repositories.CourseRepository;
import jakarta.transaction.Transactional;

@Service
public class TrainerServiceImplementation implements TrainerService {

    @Autowired
    private CourseRepository courseRepository;

   

    @Override
    public String addCourse(Course course) {
        // Extract the video ID if the YouTube URL is provided
        String fullUrl = course.getYoutubeVideoUrl();
        String videoId = extractVideoId(fullUrl);
        course.setYoutubeVideoUrl(videoId); // Store only the video ID

        courseRepository.save(course);
        return "Course added successfully!";
    }
    
    private String extractVideoId(String url) {
        try {
            if (url.contains("youtu.be")) {
                return url.substring(url.lastIndexOf("/") + 1, url.indexOf("?"));
            } else if (url.contains("youtube.com")) {
                return url.substring(url.indexOf("v=") + 2, url.indexOf("&") > -1 ? url.indexOf("&") : url.length());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid YouTube URL");
        }
        return null;
    }

    @Override
    public List<Course> fetchAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public String saveCourse(Course course) {
        courseRepository.save(course);
        return "Course updated successfully!";
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
        System.out.println("Service - Deleting comments for course ID: " + courseId);
        

        System.out.println("Service - Deleting course with ID: " + courseId);
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Course with ID " + courseId + " does not exist");
        }
        courseRepository.deleteById(courseId);
        System.out.println("Service - Course with ID " + courseId + " successfully deleted.");
    }
}
