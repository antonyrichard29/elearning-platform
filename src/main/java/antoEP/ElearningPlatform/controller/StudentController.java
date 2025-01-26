package antoEP.ElearningPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antoEP.ElearningPlatform.entities.Course;
import antoEP.ElearningPlatform.services.StudentService;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    
   

    @GetMapping("/myCourses")
    public String myCourses(Model model) {
        List<Course> courseList = studentService.fetchCourseList();
        System.out.println("Course List: " + courseList); // Debugging
        model.addAttribute("courseList", courseList);
        return "myCourses";
    }



    @GetMapping("/viewCourse")
    public String viewCourse(@RequestParam int courseId, Model model) {
        Course course = studentService.fetchCourse(courseId);

        model.addAttribute("course", course); // Pass course details to the view

        return "courseDetails"; // Render the courseDetails.html template
    }
 

}
