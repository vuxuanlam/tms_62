package tms62.model.entity;

import java.io.Serializable;
import java.util.List;

public class CoursesSubjects implements Serializable {
    
    private static final long   serialVersionUID = 1L;
    private int                 courseSubjectId;
    private byte                status;
    private Courses             course;
    private Subjects            subject;
    private List<UsersSubjects> listUserSubject;
    
    public int getCourseSubjectId() {
    
        return courseSubjectId;
    }
    
    public void setCourseSubjectId(int courseSubjectId) {
    
        this.courseSubjectId = courseSubjectId;
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
    
    public Subjects getSubject() {
    
        return subject;
    }
    
    public void setSubject(Subjects subject) {
    
        this.subject = subject;
    }
    
    public List<UsersSubjects> getListUserSubject() {
    
        return listUserSubject;
    }
    
    public void setListUserSubject(List<UsersSubjects> listUserSubject) {
    
        this.listUserSubject = listUserSubject;
    }
}
