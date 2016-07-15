package tms62.business.impl;

import tms62.business.UserBusiness;
import tms62.dao.UserDAO;
import tms62.model.entity.Users;

public class UserBusinessImpl implements UserBusiness {

  private UserDAO userDAO;

  public UserDAO getUserDAO() {

    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO) {

    this.userDAO = userDAO;
  }

  @Override
  public Users findUserByEmailPassword(Users user) {

    Users tempUser;
    try {
      tempUser = userDAO.findUserByEmailPassword(user);
      return tempUser;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
