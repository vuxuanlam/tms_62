package tms62.business;

import java.util.List;

import tms62.model.entity.Users;

public interface AccountBusiness {
    
    public List<Users> getAllUsers();
    
    public Users updateUserInfo(Users user);
    
    public Users getUserByEmail(String email);
    
    public Users getUserById(int id);
    public boolean createAccount(Users user);
}
