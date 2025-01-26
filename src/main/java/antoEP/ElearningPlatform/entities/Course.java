package antoEP.ElearningPlatform.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId; // Unique identifier for the course

    private String courseName; // Name of the course

    @Column(columnDefinition = "LONGTEXT")
    private String content; // Course content description, supports large text

    private String youtubeVideoUrl; // YouTube video URL

    @ManyToMany
    private List<Users> userList; // List of users enrolled in this course

    public Course() {}

    public Course(int courseId, String courseName, String content, String youtubeVideoUrl, List<Users> userList) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.content = content;
        this.youtubeVideoUrl = youtubeVideoUrl;
        this.userList = userList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYoutubeVideoUrl() {
        return youtubeVideoUrl;
    }

    public void setYoutubeVideoUrl(String youtubeVideoUrl) {
        this.youtubeVideoUrl = youtubeVideoUrl;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", content=" + content
                + ", youtubeVideoUrl=" + youtubeVideoUrl + ", userList=" + userList + "]";
    }
}

