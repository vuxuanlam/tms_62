package tms62.business;

import tms62.model.entity.Users;



public interface UserBusiness {

  public Users findUserByEmailPassword(Users user);
}
