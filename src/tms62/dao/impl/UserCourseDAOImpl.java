package tms62.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tms62.constant.DatabaseValue;
import tms62.dao.UserCourseDAO;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;

public class UserCourseDAOImpl extends GenericDAOImpl<UsersCourses, Integer> implements UserCourseDAO {
    
    public UserCourseDAOImpl() {
    
        super(UsersCourses.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
	public UsersCourses isMyCourse(Users user, Courses course) throws Exception {

		try {
			Query query = getSession().getNamedQuery("IsMyCourse");
			query.setParameter(DatabaseValue.USER_ID, user.getUserId());
			query.setParameter(DatabaseValue.COURSE_ID, course.getCourseId());
			return (UsersCourses) query.uniqueResult();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
