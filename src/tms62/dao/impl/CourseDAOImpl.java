package tms62.dao.impl;

import tms62.dao.CourseDAO;
import tms62.model.entity.Courses;

public class CourseDAOImpl extends GenericDAOImpl<Courses, Integer> implements
        CourseDAO {
    
    public static final String NAME = "COURSES";

    public CourseDAOImpl() {

        super(Courses.class);
    }
    
    protected void initDAO() {
    
    }
}
