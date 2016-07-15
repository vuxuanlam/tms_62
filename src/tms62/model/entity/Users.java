package tms62.model.entity;

import java.util.Date;

public class Users {

  private int     userId;
  private String  name;
  private String  password;
  private String  email;
  private boolean role;
  private Date    createAt;
  private Date    updateAt;
  
  public int getUserId() {
  
    return userId;
  }
  
  public void setUserId(int userId) {
  
    this.userId = userId;
  }
  
  public String getName() {
  
    return name;
  }
  
  public void setName(String name) {
  
    this.name = name;
  }
  
  public String getPassword() {
  
    return password;
  }
  
  public void setPassword(String password) {
  
    this.password = password;
  }
  
  public String getEmail() {
  
    return email;
  }
  
  public void setEmail(String email) {
  
    this.email = email;
  }
  
  public boolean isRole() {
  
    return role;
  }
  
  public void setRole(boolean role) {
  
    this.role = role;
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
}
