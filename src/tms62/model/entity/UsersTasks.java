package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class UsersTasks implements Serializable {
    
    private static final long          serialVersionUID = 1L;
    private int                        userTaskId;
    private byte                       status;
    private Date                       createAt;
    private Date                       updateAt;
    private Tasks                      task;
    private Users                      user;
    private List<CoursesSubjectsTasks> listCourseSubjectTask;
    
    public Tasks getTask() {
        
        return task;
    }
    
    public void setTask(Tasks task) {
        
        this.task = task;
    }
    
    public int getUserTaskId() {
        
        return userTaskId;
    }
    
    public void setUserTaskId(int userTaskId) {
        
        this.userTaskId = userTaskId;
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
    
    public Users getUser() {
        
        return user;
    }
    
    public void setUser(Users user) {
        
        this.user = user;
    }
    
    @JsonIgnore
    public List<CoursesSubjectsTasks> getListCourseSubjectTask() {
        
        return listCourseSubjectTask;
    }
    
    public void setListCourseSubjectTask(
            List<CoursesSubjectsTasks> listCourseSubjectTask) {
            
        this.listCourseSubjectTask = listCourseSubjectTask;
    }
}
