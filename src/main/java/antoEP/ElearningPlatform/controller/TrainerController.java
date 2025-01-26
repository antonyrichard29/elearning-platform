package antoEP.ElearningPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import antoEP.ElearningPlatform.entities.Course;
import antoEP.ElearningPlatform.services.TrainerService;

@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute Course course) {
        String content = course.getContent();
        if (content != null) {
            // Split the content into paragraph and points
            String[] parts = content.split("\\n(?=\\d\\.)"); // Splits at numbered points like "1."
            StringBuilder formattedContent = new StringBuilder();

            // Add the paragraph
            if (parts.length > 0) {
                formattedContent.append("<p style='text-align:justify;'>").append(parts[0].trim()).append("</p>");
            }

            // Add the numbered points
            if (parts.length > 1) {
                formattedContent.append("<ol>");
                for (int i = 1; i < parts.length; i++) { // Start from the second part
                    formattedContent.append("<li>").append(parts[i].trim().replaceFirst("\\d\\.", "").trim()).append("</li>");
                }
                formattedContent.append("</ol>");
            }

            course.setContent(formattedContent.toString());
        }
        

        trainerService.addCourse(course);
        return "redirect:/trainerHome";
    }

    @GetMapping("/viewCourses")
    public String viewCourses(Model model) {
        List<Course> courseList = trainerService.fetchAllCourses();
        model.addAttribute("courseList", courseList);
        return "courses";
    }

    
    @PostMapping("/deleteCourse")
    public String deleteCourse(@ModelAttribute("courseId") int courseId) {
        System.out.println("Controller - Received courseId: " + courseId);
        trainerService.deleteCourse(courseId);
        return "redirect:/viewCourses";
    }
}
