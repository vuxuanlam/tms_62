package tms62.dao.impl;

import tms62.dao.UserCourseDAO;
import tms62.model.entity.UsersCourses;

public class UserCourseDAOImpl extends GenericDAOImpl<UsersCourses, Integer>
        implements UserCourseDAO {
    
    public UserCourseDAOImpl() {
    
        super(UsersCourses.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
