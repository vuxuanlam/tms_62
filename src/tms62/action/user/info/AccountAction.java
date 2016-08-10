package tms62.action.user.info;

import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private AccountBusiness   accountBusiness;
    private SessionMap        session;
    private Users             currentUser;
    private Users             user;

    public Users getUser() {

        return user;
    }
    
    public void setUser(Users user) {

        this.user = user;
    }
    
    private AccountDetails accountDetails = (AccountDetails) SecurityContextHolder
                                                  .getContext()
                                                  .getAuthentication()
                                                  .getPrincipal();

    public AccountBusiness getAccountBusiness() {

        return accountBusiness;
    }
    
    public void setAccountBusiness(AccountBusiness accountBusiness) {

        this.accountBusiness = accountBusiness;
    }
    
    public Users getCurrentUser() {

        return currentUser;
    }
    
    public void setCurrentUser(Users currentUser) {

        this.currentUser = currentUser;
    }
    
    public String viewAccount() {

        // currentUser =
        // accountBusiness.getUserById(accountDetails.getUserId());
        currentUser = accountDetails.getUser();
        return SUCCESS;
    }
    
    public String editAccount() throws Exception {
    
        // currentUser =
        // accountBusiness.getUserById(accountDetails.getUserId());
        currentUser = accountDetails.getUser();
        if (user != null) {
            accountBusiness.updateUserInfo(user);
        }
        return SUCCESS;
    }
}
