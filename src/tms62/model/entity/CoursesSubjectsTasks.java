package tms62.model.entity;

import java.io.Serializable;

public class CoursesSubjectsTasks implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int               courseSubjectTaskId;
  private int               userTaskId;
  private int               userSubjectId;
  private int               courseSubjectId;

  public int getCourseSubjectTaskId() {

    return courseSubjectTaskId;
  }

  public void setCourseSubjectTaskId(int courseSubjectTaskId) {

    this.courseSubjectTaskId = courseSubjectTaskId;
  }

  public int getUserTaskId() {

    return userTaskId;
  }

  public void setUserTaskId(int userTaskId) {

    this.userTaskId = userTaskId;
  }

  public int getUserSubjectId() {

    return userSubjectId;
  }

  public void setUserSubjectId(int userSubjectId) {

    this.userSubjectId = userSubjectId;
  }

  public int getCourseSubjectId() {

    return courseSubjectId;
  }

  public void setCourseSubjectId(int courseSubjectId) {

    this.courseSubjectId = courseSubjectId;
  }

}
