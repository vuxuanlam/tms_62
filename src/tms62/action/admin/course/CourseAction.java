package tms62.action.admin.course;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.AdminBusiness;
import tms62.constant.message.PermissionMessage;
import tms62.constant.message.WrongAccess;
import tms62.constant.value.DatabaseValue;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport implements SessionAware {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private SessionMap        session;
  private AdminBusiness     adminBusiness;
  private List<Courses>     listCourses;
  private Courses           currentCourse;

  public AdminBusiness getAdminBusiness() {

    return adminBusiness;
  }

  public void setAdminBusiness(AdminBusiness adminBusiness) {

    this.adminBusiness = adminBusiness;
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

    Users currentUser;
    currentUser = Helpers.getCurrentUserFromSession();
    if (Helpers.isExist(currentUser)
        && currentUser.isRole() == DatabaseValue.ADMIN) {
      listCourses = adminBusiness.getAllCourses();
      return SUCCESS;
    }
    addActionError(PermissionMessage.DEFAULT);
    return ERROR;
  }

  public String viewCourseDetails() {

    Users currentUser = Helpers.getCurrentUserFromSession();
    if (Helpers.isExist(currentUser)) {
      currentCourse = adminBusiness.getCourseById(currentCourse);
      if (Helpers.isExist(currentCourse))
        return SUCCESS;
      else {
        addActionError(WrongAccess.NOTFOUND);
        return ERROR;
      }
    }

    addActionError(PermissionMessage.DEFAULT);
    return ERROR;
  }

}
