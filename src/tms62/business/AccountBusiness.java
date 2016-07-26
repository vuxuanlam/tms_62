package tms62.business;

import java.util.List;

import tms62.model.entity.Users;

public interface AccountBusiness {

  public List<Users> getAllUsers();

  public Users updateUserInfo(Users user) throws Exception;

  public Users getUserByEmail(String email);
}
