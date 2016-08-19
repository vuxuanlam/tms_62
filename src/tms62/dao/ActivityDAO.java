package tms62.dao;

import java.util.List;

import tms62.model.entity.Activities;
import tms62.model.entity.Users;

public interface ActivityDAO extends GenericDAO<Activities, Integer> {
    
    public void saveActivities(Users user, String targetType, int targetId,
            String log) throws Exception;
    
    public List<Activities> getListActivities(Activities activity)
            throws Exception;
    
    public List<Activities> getListActivities(String targetType)
            throws Exception;
}
