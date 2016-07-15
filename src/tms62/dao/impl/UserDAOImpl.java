package tms62.dao.impl;

import org.hibernate.Query;

import tms62.constant.value.DatabaseValue;
import tms62.dao.UserDAO;
import tms62.model.entity.Users;

public class UserDAOImpl extends GenericDAOImpl<Users, Integer> implements
    UserDAO {

  public UserDAOImpl() {

    super(Users.class);
  }

  protected void initDAO() {

    // Do nothing
  }

  public Users findUserByEmailPassword(Users user) throws Exception {

    try {
      Query query = getSession().getNamedQuery("FindUserByEmailPassword");
      query.setParameter(DatabaseValue.EMAIL, user.getEmail());
      query.setParameter(DatabaseValue.PASSWORD, user.getPassword());
      return (Users) query.uniqueResult();
    } catch (RuntimeException re) {
      re.printStackTrace();
      throw re;
    }
  }
}
