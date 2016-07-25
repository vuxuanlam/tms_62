package tms62.model.entity;

import java.io.Serializable;

public class CoursesSubjects implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int               courseSubjectId;
  private boolean           status;
  private Courses           course;
  private Subjects          subject;

  public CoursesSubjects(){}
  public CoursesSubjects(int courseSubjectId, boolean status, Courses course, Subjects subject){}
  public int getCourseSubjectId() {

    return courseSubjectId;
  }

  public void setCourseSubjectId(int courseSubjectId) {

    this.courseSubjectId = courseSubjectId;
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

  public Subjects getSubject() {

    return subject;
  }

  public void setSubject(Subjects subject) {

    this.subject = subject;
  }

}
