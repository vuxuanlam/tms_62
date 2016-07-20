package tms62.business.impl;

import java.util.List;

import tms62.business.AccountBusiness;
import tms62.dao.UserDAO;
import tms62.model.entity.Users;

public class AccountBusinessImpl implements AccountBusiness {

	private UserDAO userDAO;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users updateUserInfo(Users user) throws Exception {
		// TODO Auto-generated method stub
		try {
			userDAO.update(user);
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
}
