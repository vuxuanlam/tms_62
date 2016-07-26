package tms62.action.admin.course;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.CourseBusiness;
import tms62.constant.message.WrongAccess;
import tms62.model.entity.Courses;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport implements SessionAware {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private SessionMap        session;
  private CourseBusiness    courseBusiness;
  private List<Courses>     listCourses;
  private Courses           currentCourse;

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

  @Override
  public void setSession(Map<String, Object> session) {

    this.session = (SessionMap) session;
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
}
