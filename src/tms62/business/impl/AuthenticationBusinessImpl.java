package tms62.business.impl;

import tms62.business.AuthenticationBusiness;
import tms62.dao.UserDAO;
import tms62.model.entity.Users;
import tms62.util.Helpers;
import tms62.util.Logit2;

public class AuthenticationBusinessImpl implements AuthenticationBusiness {

    private UserDAO             userDAO;
    private static final Logit2 log = Logit2.getInstance(AuthenticationBusinessImpl.class);

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
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }
}
