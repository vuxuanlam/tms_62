package tms62.dao.impl;

import tms62.dao.TaskDAO;
import tms62.model.entity.Tasks;

public class TaskDAOImpl extends GenericDAOImpl<Tasks, Integer> implements
        TaskDAO {
    
    public static final String NAME = "TASKS";

    public TaskDAOImpl() {
    
        super(Tasks.class);
    }
    
    protected void initDAO() {
    
        // Do nothing
    }
}
