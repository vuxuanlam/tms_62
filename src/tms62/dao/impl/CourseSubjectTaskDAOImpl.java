package tms62.dao.impl;

import tms62.dao.CourseSubjectTaskDAO;
import tms62.model.entity.CoursesSubjectsTasks;

public class CourseSubjectTaskDAOImpl extends
        GenericDAOImpl<CoursesSubjectsTasks, Integer> implements
        CourseSubjectTaskDAO {
    
    public CourseSubjectTaskDAOImpl() {
    
        super(CoursesSubjectsTasks.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
