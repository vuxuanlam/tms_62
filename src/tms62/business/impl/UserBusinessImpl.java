package tms62.business.impl;

import java.util.ArrayList;
import java.util.List;

import tms62.business.UserBusiness;
import tms62.constant.value.DatabaseValue;
import tms62.dao.CourseDAO;
import tms62.dao.UserCourseDAO;
import tms62.dao.UserDAO;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;
import tms62.util.Helpers;

public class UserBusinessImpl implements UserBusiness {

  private UserDAO       userDAO;
  private CourseDAO     courseDAO;
  private UserCourseDAO userCourseDAO;

  public UserDAO getUserDAO() {

    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO) {

    this.userDAO = userDAO;
  }

  public CourseDAO getCourseDAO() {

    return courseDAO;
  }

  public void setCourseDAO(CourseDAO courseDAO) {

    this.courseDAO = courseDAO;
  }

  public UserCourseDAO getUserCourseDAO() {

    return userCourseDAO;
  }

  public void setUserCourseDAO(UserCourseDAO userCourseDAO) {

    this.userCourseDAO = userCourseDAO;
  }

  @Override
  public Users checkUserSignin(Users user) {

    Users tempUser;
    try {
      tempUser = userDAO.findUserByEmailPassword(user);
      if (Helpers.isExist(tempUser))
        return tempUser;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Courses> getMyListCourses(Users user) {

    List<UsersCourses> listUserCourse;
    List<Courses> listCourse;
    Courses myCourse;
    try {
      listUserCourse = userCourseDAO.findByProperty(DatabaseValue.USER_ID,
          user.getUserId());
      if (!Helpers.isEmpty(listUserCourse)) {
        listCourse = new ArrayList<Courses>();
        for (UsersCourses userCourse : listUserCourse) {
          myCourse = courseDAO.findById(userCourse.getCourseId());
          if (Helpers.isExist(myCourse)) {
            myCourse.setStatus(userCourse.isStatus());
            listCourse.add(myCourse);
          }
        }
        return listCourse;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Courses getMyCourseDetails(Users user, Courses course) {

    UsersCourses myUserCourse;
    try {
      myUserCourse = userCourseDAO.isMyCourse(user, course);
      if (Helpers.isExist(myUserCourse)) {
        return courseDAO.findById(myUserCourse.getCourseId());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
