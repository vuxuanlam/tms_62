package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Subjects implements Serializable {
    
    private static final long     serialVersionUID = 1L;
    private int                   subjectId;
    private String                name;
    private String                description;
    private Date                  createAt;
    private Date                  updateAt;
    private List<Tasks>           listTasks;
    private List<CoursesSubjects> listCoursesSubjects;
    
    public int getSubjectId() {
    
        return subjectId;
    }
    
    public void setSubjectId(int subjectId) {
    
        this.subjectId = subjectId;
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
    
    public List<Tasks> getListTasks() {
    
        return listTasks;
    }
    
    public void setListTasks(List<Tasks> listTasks) {
    
        this.listTasks = listTasks;
    }
    
    public List<CoursesSubjects> getListCoursesSubjects() {
    
        return listCoursesSubjects;
    }
    
    public void setListCoursesSubjects(List<CoursesSubjects> listCoursesSubjects) {
    
        this.listCoursesSubjects = listCoursesSubjects;
    }
}
