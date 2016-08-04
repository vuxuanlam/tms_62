package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Activities implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int               activityId;
    private String            targetType;
    private int               targetId;
    private String            description;
    private Date              createAt;
    private Users             user;
    
    public int getActivityId() {
    
        return activityId;
    }
    
    public void setActivityId(int activityId) {
    
        this.activityId = activityId;
    }
    
    public String getTargetType() {
    
        return targetType;
    }
    
    public void setTargetType(String targetType) {
    
        this.targetType = targetType;
    }
    
    public int getTargetId() {
    
        return targetId;
    }
    
    public void setTargetId(int targetId) {
    
        this.targetId = targetId;
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
    
    public Users getUser() {
    
        return user;
    }
    
    public void setUser(Users user) {
    
        this.user = user;
    }
}
