package tms62.business.impl;

import java.util.List;

import tms62.business.AdminBusiness;
import tms62.dao.CourseDAO;
import tms62.dao.UserDAO;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;

public class AdminBusinessImpl implements AdminBusiness {

  private UserDAO   userDAO;
  private CourseDAO courseDAO;

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

  @Override
  public List<Users> getAllUsers() {

    try {
      return userDAO.listAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
