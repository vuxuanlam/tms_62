package tms62.model.entity;

import java.io.Serializable;

public class CoursesSubjectsTasks implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int               courseSubjectTaskId;
    private UsersTasks        userTask;
    private UsersSubjects     userSubject;
    
    public int getCourseSubjectTaskId() {
    
        return courseSubjectTaskId;
    }
    
    public void setCourseSubjectTaskId(int courseSubjectTaskId) {
    
        this.courseSubjectTaskId = courseSubjectTaskId;
    }
    
    public UsersTasks getUserTask() {
    
        return userTask;
    }
    
    public UsersSubjects getUserSubject() {
    
        return userSubject;
    }
    
    public void setUserTask(UsersTasks userTask) {
    
        this.userTask = userTask;
    }
    
    public void setUserSubject(UsersSubjects userSubject) {
    
        this.userSubject = userSubject;
    }
}
