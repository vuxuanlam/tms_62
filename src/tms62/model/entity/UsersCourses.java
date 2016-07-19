package tms62.model.entity;

public class UsersCourses {

  private int     courseId;
  private int     userId;
  private boolean status;

  public int getCourseId() {

    return courseId;
  }

  public void setCourseId(int courseId) {

    this.courseId = courseId;
  }

  public int getUserId() {

    return userId;
  }

  public void setUserId(int userId) {

    this.userId = userId;
  }

  public boolean isStatus() {

    return status;
  }

  public void setStatus(boolean status) {

    this.status = status;
  }

}
