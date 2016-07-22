package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Tasks implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int               taskId;
    private String            name;
    private String            description;
    private Date              createAt;
    private Date              updateAt;
    private Subjects          subject;
    private List<UsersTasks>  listUsersTasks;
    
    public int getTaskId() {
    
        return taskId;
    }
    
    public void setTaskId(int taskId) {
    
        this.taskId = taskId;
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
    
    public Subjects getSubject() {
    
        return subject;
    }
    
    public void setSubject(Subjects subject) {
    
        this.subject = subject;
    }
    
    public List<UsersTasks> getListUsersTasks() {
    
        return listUsersTasks;
    }
    
    public void setListUsersTasks(List<UsersTasks> listUsersTasks) {
    
        this.listUsersTasks = listUsersTasks;
    }
}
