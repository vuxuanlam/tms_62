package tms62.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Courses implements Serializable {
    
    private static final long     serialVersionUID = 1L;
    private int                   courseId;
    private String                name;
    private String                description;
    private Date                  startDate;
    private Date                  endDate;
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
    
    public Date getStartDate() {
    
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
    
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
    
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
    
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
    
    public List<CoursesSubjects> getListCoursesSubjects() {
    
        return listCoursesSubjects;
    }
    
    public void setListCoursesSubjects(List<CoursesSubjects> listCoursesSubjects) {
    
        this.listCoursesSubjects = listCoursesSubjects;
    }
    
    public List<UsersCourses> getListUsersCourses() {
    
        return listUsersCourses;
    }
    
    public void setListUsersCourses(List<UsersCourses> listUsersCourses) {
    
        this.listUsersCourses = listUsersCourses;
    }

    public void setStartDate(String startDate) {

        try {
            this.startDate = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(startDate);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setEndDate(String endDate) {

        try {
            this.endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
