package tms62.business;

import java.util.List;

import tms62.model.entity.Courses;
import tms62.model.entity.Users;

public interface UserBusiness {

  public Users checkUserSignin(Users user);

  public List<Courses> getMyListCourses(Users user);

  public Courses getMyCourseDetails(Users user, Courses course);

}
