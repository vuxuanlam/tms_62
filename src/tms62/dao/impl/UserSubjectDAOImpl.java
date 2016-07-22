package tms62.dao.impl;

import tms62.dao.UserSubjectDAO;
import tms62.model.entity.UsersSubjects;

public class UserSubjectDAOImpl extends GenericDAOImpl<UsersSubjects, Integer>
        implements UserSubjectDAO {
    
    public UserSubjectDAOImpl() {
    
        super(UsersSubjects.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
