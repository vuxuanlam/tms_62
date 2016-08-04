package tms62.dao.impl;

import tms62.dao.CourseSubjectDAO;
import tms62.model.entity.CoursesSubjects;

public class CourseSubjectDAOImpl extends
        GenericDAOImpl<CoursesSubjects, Integer> implements CourseSubjectDAO {
    
    public CourseSubjectDAOImpl() {
    
        super(CoursesSubjects.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
