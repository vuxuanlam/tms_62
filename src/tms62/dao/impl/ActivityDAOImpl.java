package tms62.dao.impl;

import tms62.dao.ActivityDAO;
import tms62.model.entity.Activities;
import tms62.model.entity.Users;

public class ActivityDAOImpl extends GenericDAOImpl<Activities, Integer>
        implements ActivityDAO {
    
    public ActivityDAOImpl() {
    
        super(Activities.class);
    }
    
    @Override
    public void saveActivities(Users user, String targetType, int targetId,
            String log) throws Exception {
    
        Activities activity = new Activities(user, targetType, targetId, log);
        try {
            this.save(activity);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
