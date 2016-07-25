package tms62.action.admin.course;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import tms62.business.CourseBusiness;
import tms62.constant.message.WrongAccess;
import tms62.model.entity.Courses;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.util.Helpers;

public class CourseAction extends ActionSupport {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private CourseBusiness    courseBusiness;
  private List<Courses>     listCourses;
  private Courses           currentCourse;
  private List<Subjects>    listSubjects;
  private CoursesSubjects   courseSubject;
  private Subjects          subject;

  public CoursesSubjects getCourseSubject() {

    return courseSubject;
  }

  public void setCourseSubject(CoursesSubjects courseSubject) {

    this.courseSubject = courseSubject;
  }

  public CourseBusiness getCourseBusiness() {

    return courseBusiness;
  }

  public void setCourseBusiness(CourseBusiness courseBusiness) {

    this.courseBusiness = courseBusiness;
  }

  public List<Courses> getListCourses() {

    return listCourses;
  }

  public void setListCourses(List<Courses> listCourses) {

    this.listCourses = listCourses;
  }

  public List<Subjects> getListSubjects() {

    return listSubjects;
  }

  public void setListSubjects(List<Subjects> listSubjects) {

    this.listSubjects = listSubjects;
  }

  public Subjects getSubject() {

    return subject;
  }

  public void setSubject(Subjects subject) {

    this.subject = subject;
  }

  public Courses getCurrentCourse() {

    return currentCourse;
  }

  public void setCurrentCourse(Courses currentCourse) {

    this.currentCourse = currentCourse;
  }

  public String viewAllCourse() {

    listCourses = courseBusiness.getAllCourses();
    return SUCCESS;
  }

  public String viewCourseDetails() {

    currentCourse = courseBusiness.getCourseById(currentCourse);
    if (Helpers.isExist(currentCourse))
      return SUCCESS;
    else {
      addActionError(WrongAccess.NOTFOUND);
      return ERROR;
    }
  }

  public String createCourse() {
    if(listSubjects==null)
      listSubjects = courseBusiness.getSubjects();
    if (Helpers.isExist(currentCourse)) {
      try {
        courseBusiness.createCourse(currentCourse, currentCourse.getCourseId(), subject.getSubjectId());
      } catch (Exception e) {
        e.printStackTrace();
      }
      return SUCCESS;
    }
    return SUCCESS;
  }

}
