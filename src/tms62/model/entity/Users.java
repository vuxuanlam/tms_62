package tms62.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements Serializable {

  private int                 userId;
  private String              name;
  private String              password;
  private String              email;
  private boolean             role;
  private Date                createAt;
  private Date                updateAt;
  private List<UsersSubjects> listUsersSubjects;
  private List<UsersCourses>  listUsersCourses;
  private List<Activities>    listActivities;
  private List<UsersTasks>    listUsersTasks;

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

  public List<UsersSubjects> getListUsersSubjects() {

    return listUsersSubjects;
  }

  public List<UsersCourses> getListUsersCourses() {

    return listUsersCourses;
  }

  public List<Activities> getListActivities() {

    return listActivities;
  }

  public List<UsersTasks> getListUsersTasks() {

    return listUsersTasks;
  }

  public void setListUsersSubjects(List<UsersSubjects> listUsersSubjects) {

    this.listUsersSubjects = listUsersSubjects;
  }

  public void setListUsersCourses(List<UsersCourses> listUsersCourses) {

    this.listUsersCourses = listUsersCourses;
  }

  public void setListActivities(List<Activities> listActivities) {

    this.listActivities = listActivities;
  }

  public void setListUsersTasks(List<UsersTasks> listUsersTasks) {

    this.listUsersTasks = listUsersTasks;
  }
}
