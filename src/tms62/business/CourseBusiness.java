package tms62.business;

import java.util.List;

import tms62.model.entity.Courses;
import tms62.model.entity.Users;

public interface CourseBusiness {

  public List<Courses> getAllCourses();

  public Courses getCourseById(Courses course);

  public List<Courses> getMyListCourses(Users user);

  public Courses getMyCourseDetails(Users user, Courses course);

}
