package tms62.business.impl;

import java.util.List;

import tms62.business.AccountBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.ActivityDAO;
import tms62.dao.UserDAO;
import tms62.dao.impl.UserDAOImpl;
import tms62.model.entity.Activities;
import tms62.model.entity.Users;
import tms62.util.Logit2;

public class AccountBusinessImpl implements AccountBusiness {

    private UserDAO             userDAO;
    private ActivityDAO         activityDAO;
    private static final Logit2 log = Logit2.getInstance(AccountBusinessImpl.class);

    public ActivityDAO getActivityDAO() {
    
        return activityDAO;
    }

    public void setActivityDAO(ActivityDAO activityDAO) {
    
        this.activityDAO = activityDAO;
    }

    public UserDAO getUserDAO() {
    
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
    
        this.userDAO = userDAO;
    }

    @Override
    public List<Users> getAllUsers() {
    
        try {
            return userDAO.listAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users updateUserInfo(Users user) {
    
        try {
            userDAO.update(user);
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Users getUserByEmail(String email) {
    
        List<Users> listUser;
        try {
            listUser = userDAO.findByProperty(DatabaseValue.EMAIL, email);
            if (listUser.size() > 0)
                return (Users) listUser.get(0);
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Users getUserById(int id) {
    
        try {
            return userDAO.findById(id);
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public boolean createAccount(Users user) {
    
        // TODO Auto-generated method stub
        try {
            userDAO.save(user);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAccount(Users user) {
    
        // TODO Auto-generated method stub
        try {
            userDAO.delete(user);
            return true;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    @Override
    public boolean updateAccount(Users user) {
    
        // TODO Auto-generated method stub
        try {
            userDAO.update(user);
            return true;
        }
        catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    @Override
    public void saveActivity(Users user, int targetId, String log) {
    
        try {
            activityDAO.saveActivities(user, UserDAOImpl.NAME, targetId, log);
        }
        catch (Exception e) {
            AccountBusinessImpl.log.error(e);
        }
    }
    
    @Override
    public List<Activities> getListActivities(Activities activity) {
    
        try {
            return activityDAO.getListActivities(activity);
        }
        catch (Exception e) {
            log.error(e);
            return null;
        }
    }
    
    @Override
    public List<Activities> getListActivities(String targetType) {
    
        try {
            return activityDAO.getListActivities(targetType);
        }
        catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
