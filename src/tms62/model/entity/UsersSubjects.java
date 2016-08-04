package tms62.model.entity;

import java.io.Serializable;
import java.util.List;

public class UsersSubjects implements Serializable {
    
    private static final long          serialVersionUID = 1L;
    private int                        userCourseSubjectId;
    private byte                       status;
    private Users                      user;
    private CoursesSubjects            courseSubject;
    private List<CoursesSubjectsTasks> listCourseSubjectTask;
    
    public int getUserCourseSubjectId() {
    
        return userCourseSubjectId;
    }
    
    public void setUserCourseSubjectId(int userCourseSubjectId) {
    
        this.userCourseSubjectId = userCourseSubjectId;
    }
    
    public byte getStatus() {
    
        return status;
    }
    
    public void setStatus(byte status) {
    
        this.status = status;
    }
    
    public Users getUser() {
    
        return user;
    }
    
    public void setUser(Users user) {
    
        this.user = user;
    }
    
    public List<CoursesSubjectsTasks> getListCourseSubjectTask() {
    
        return listCourseSubjectTask;
    }
    
    public void setListCourseSubjectTask(
            List<CoursesSubjectsTasks> listCourseSubjectTask) {
    
        this.listCourseSubjectTask = listCourseSubjectTask;
    }
    
    public CoursesSubjects getCourseSubject() {
    
        return courseSubject;
    }
    
    public void setCourseSubject(CoursesSubjects courseSubject) {
    
        this.courseSubject = courseSubject;
    }
}
