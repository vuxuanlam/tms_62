package tms62.business.impl;

import tms62.business.AuthenticationBusiness;
import tms62.dao.UserDAO;
import tms62.model.entity.Users;
import tms62.util.Helpers;

public class AuthenticationBusinessImpl implements AuthenticationBusiness {

  private UserDAO userDAO;

  public UserDAO getUserDAO() {

    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO) {

    this.userDAO = userDAO;
  }

  @Override
  public Users checkUserSignin(Users user) {

    Users tempUser;
    try {
      tempUser = userDAO.findUserByEmailPassword(user);
      if (Helpers.isExist(tempUser))
        return tempUser;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
