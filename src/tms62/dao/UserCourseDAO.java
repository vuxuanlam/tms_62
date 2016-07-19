package tms62.dao;

import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;

public interface UserCourseDAO extends GenericDAO<UsersCourses, Integer> {

  public UsersCourses isMyCourse(Users user, Courses course) throws Exception;
}
