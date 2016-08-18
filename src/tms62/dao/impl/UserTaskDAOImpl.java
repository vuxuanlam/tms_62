package tms62.dao.impl;

import tms62.dao.UserTaskDAO;
import tms62.model.entity.UsersTasks;

public class UserTaskDAOImpl extends GenericDAOImpl<UsersTasks, Integer>
        implements UserTaskDAO {
    
    public UserTaskDAOImpl() {
    
        super(UsersTasks.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
