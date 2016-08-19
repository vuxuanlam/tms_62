package tms62.dao.impl;

import java.util.Collections;
import java.util.List;

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
    
    @Override
    public List<Activities> getListActivities(Activities activity)
            throws Exception {
    
        try {
            List<Activities> listActivities;
            listActivities = this.findByExample(activity);
            Collections.reverse(listActivities);
            return listActivities;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public List<Activities> getListActivities(String targetType)
            throws Exception {
    
        try {
            List<Activities> listActivities;
            listActivities = this.findByProperty("targetType", targetType);
            Collections.reverse(listActivities);
            return listActivities;
        }
        catch (Exception e) {
            throw e;
        }
    }
}
