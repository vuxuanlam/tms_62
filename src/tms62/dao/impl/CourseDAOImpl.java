package tms62.dao.impl;

import org.hibernate.Query;

import tms62.dao.CourseDAO;
import tms62.model.entity.Courses;

public class CourseDAOImpl extends GenericDAOImpl<Courses, Integer>
    implements CourseDAO {

  public CourseDAOImpl() {

    super(Courses.class);
  }

  protected void initDAO() {

    // Do nothing
  }

  @Override
  public void saveCourse(Courses course, int courseId, int subjectId)
      throws Exception {

    // TODO Auto-generated method stub

    try {
      save(course);
      String hql = "INSERT INTO db_tms_62.coursessubjects(courseSubjectId, subjectId, courseId, status )values('0','"
          + subjectId + "', '" + courseId + "', '0')";
      Query query = getSession().createSQLQuery(hql);
      int result = query.executeUpdate();
    } catch (Exception e) {
      throw e;
    }
  }

}
