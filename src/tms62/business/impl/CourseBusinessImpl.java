package tms62.business.impl;

import java.util.ArrayList;
import java.util.List;

import tms62.business.CourseBusiness;
import tms62.dao.CourseDAO;
import tms62.dao.UserCourseDAO;
import tms62.dao.UserDAO;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;

public class CourseBusinessImpl implements CourseBusiness {

  private CourseDAO     courseDAO;
  private UserCourseDAO userCourseDAO;
  private UserDAO       userDAO;

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
  public List<Courses> getMyListCourses(Users user) {

    List<Courses> listCourse = new ArrayList<Courses>();
    List<UsersCourses> listUsersCourses;
    UsersCourses myUserCourse;
    try {
      user = userDAO.findById(user.getUserId());
      listUsersCourses = user.getListUsersCourses();
      for (UsersCourses userCourse : listUsersCourses) {
        myUserCourse = userCourseDAO.findById(userCourse.getUserCourseId());
        myUserCourse.getCourse().setStatus(userCourse.isStatus());
        listCourse.add(myUserCourse.getCourse());
      }
      return listCourse;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Courses getMyCourseDetails(Users user, Courses course) {

    List<UsersCourses> myListUsersCourses;
    Courses myCourse;
    try {
      user = userDAO.findById(user.getUserId());
      myListUsersCourses = user.getListUsersCourses();
      for (UsersCourses userCourse : myListUsersCourses) {
        myCourse = userCourse.getCourse();
        if (myCourse.getCourseId() == course.getCourseId()) {
          myCourse.setStatus(userCourse.isStatus());
          return myCourse;
        }
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public List<Courses> getAllCourses() {

    try {
      return courseDAO.listAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Courses getCourseById(Courses course) {

    try {
      return courseDAO.findById(course.getCourseId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
