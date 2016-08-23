package tms62.model.entity;

import java.io.Serializable;

public class UsersCourses implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int               userCourseId;
    private byte              status;
    private Courses           course;
    private Users             user;
    private int               progressOfCourse;
    
    
    public int getProgressOfCourse() {
        
        return progressOfCourse;
    }

    
    public void setProgressOfCourse(int progressOfCourse) {
        
        this.progressOfCourse = progressOfCourse;
    }

    public int getUserCourseId() {
        
        return userCourseId;
    }
    
    public void setUserCourseId(int userCourseId) {
        
        this.userCourseId = userCourseId;
    }
    
    public byte getStatus() {
        
        return status;
    }
    
    public void setStatus(byte status) {
        
        this.status = status;
    }
    
    public Courses getCourse() {
        
        return course;
    }
    
    public void setCourse(Courses course) {
        
        this.course = course;
    }
    
    public Users getUser() {
        
        return user;
    }
    
    public void setUser(Users user) {
        
        this.user = user;
    }
}
