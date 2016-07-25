package tms62.dao;

import tms62.model.entity.Courses;
import tms62.model.entity.CoursesSubjects;

public interface CourseDAO extends GenericDAO<Courses, Integer> {
  public void saveCourse(Courses course, int courseId, int subjectId) throws Exception;
}
