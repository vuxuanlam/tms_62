package tms62.business;

import tms62.model.entity.Users;

public interface AuthenticationBusiness {

  public Users checkUserSignin(Users user);

}
