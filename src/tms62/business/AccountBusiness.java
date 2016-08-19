package tms62.business;

import java.util.List;

import tms62.model.entity.Activities;
import tms62.model.entity.Users;

public interface AccountBusiness {
    
    public List<Users> getAllUsers();
    
    public Users updateUserInfo(Users user);
    
    public Users getUserByEmail(String email);
    
    public Users getUserById(int id);

    public boolean createAccount(Users user);

    public boolean deleteAccount(Users user);

    public boolean updateAccount(Users user);
    
    public void saveActivity(Users users, int target, String log);
    
    public List<Activities> getListActivities(Activities activity);
    
    public List<Activities> getListActivities(String targetType);
}
