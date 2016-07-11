package tms62.action.user.course;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.UserBusiness;
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
  private UserBusiness      userBusiness;
  private SessionMap        session;
  private List<Courses>     listCourses;
  private Courses           currentCourse;

  public UserBusiness getUserBusiness() {

    return userBusiness;
  }

  public void setUserBusiness(UserBusiness userBusiness) {

    this.userBusiness = userBusiness;
  }

  public List<Courses> getListCourses() {

    return listCourses;
  }

  public void setListCourses(List<Courses> listMyCourses) {

    this.listCourses = listMyCourses;
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

  public String viewMyCourse() {

    Users currentUser = Helpers.getCurrentUserFromSession();
    if (Helpers.isExist(currentUser)
        && currentUser.isRole() == DatabaseValue.USER) {
      listCourses = userBusiness.getMyListCourses(currentUser);
      return SUCCESS;
    }
    addActionError(WrongAccess.DEFAULT);
    return ERROR;
  }

  public String viewMyCourseDetails() {

    Users currentUser = Helpers.getCurrentUserFromSession();
    if (Helpers.isExist(currentUser)
        && currentUser.isRole() == DatabaseValue.USER) {
      currentCourse = userBusiness.getMyCourseDetails(currentUser,
          currentCourse);
      if (Helpers.isExist(currentCourse))
        return SUCCESS;
    }
    addActionError(WrongAccess.NOTFOUND);
    return ERROR;
  }
}
