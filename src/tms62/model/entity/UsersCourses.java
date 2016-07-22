package tms62.model.entity;

import java.io.Serializable;

public class UsersCourses implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int               userCourseId;
  private boolean           status;
  private Courses           course;
  private Users             user;

  public int getUserCourseId() {

    return userCourseId;
  }

  public void setUserCourseId(int userCourseId) {

    this.userCourseId = userCourseId;
  }

  public boolean isStatus() {

    return status;
  }

  public void setStatus(boolean status) {

    this.status = status;
  }

  public Courses getCourse() {

    return course;
  }

  public void setCourse(Courses course) {

    this.course = course;
  }

  public Users getUser() {

    return user;
  }

  public void setUser(Users user) {

    this.user = user;
  }

}
