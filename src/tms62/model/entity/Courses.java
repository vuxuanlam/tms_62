package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Courses implements Serializable {
    
    private static final long     serialVersionUID = 1L;
    private int                   courseId;
    private String                name;
    private String                description;
    private String                startDate;
    private String                endDate;
    private byte                  status;
    private Date                  createAt;
    private Date                  updateAt;
    private List<CoursesSubjects> listCoursesSubjects;
    private List<UsersCourses>    listUsersCourses;
    
    public int getCourseId() {
        
        return courseId;
    }
    
    public void setCourseId(int courseId) {
        
        this.courseId = courseId;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getDescription() {
        
        return description;
    }
    
    public void setDescription(String description) {
        
        this.description = description;
    }
    
    public String getStartDate() {
        
        return startDate;
    }
    
    public void setStartDate(String startDate) {
        
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        
        return endDate;
    }
    
    public void setEndDate(String endDate) {
        
        this.endDate = endDate;
    }
    
    public byte getStatus() {
        
        return status;
    }
    
    public void setStatus(byte status) {
        
        this.status = status;
    }
    
    public Date getCreateAt() {
        
        return createAt;
    }
    
    public void setCreateAt(Date createAt) {
        
        this.createAt = createAt;
    }
    
    public Date getUpdateAt() {
        
        return updateAt;
    }
    
    public void setUpdateAt(Date updateAt) {
        
        this.updateAt = updateAt;
    }
    
    @JsonIgnore
    public List<CoursesSubjects> getListCoursesSubjects() {
        
        return listCoursesSubjects;
    }
    
    public void setListCoursesSubjects(
            List<CoursesSubjects> listCoursesSubjects) {
            
        this.listCoursesSubjects = listCoursesSubjects;
    }
    
    @JsonIgnore
    public List<UsersCourses> getListUsersCourses() {
        
        return listUsersCourses;
    }
    
    public void setListUsersCourses(List<UsersCourses> listUsersCourses) {
        
        this.listUsersCourses = listUsersCourses;
    }
}
