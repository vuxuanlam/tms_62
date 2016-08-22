package tms62.action.user.info;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private AccountBusiness   accountBusiness;
    private Users             currentUser;
    private Users             user;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();

    public Users getUser() {

        return user;
    }
    
    public void setUser(Users user) {

        this.user = user;
    }
    
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
    
        currentUser = accountBusiness.getUserById(accountDetails.getUser()
                .getUserId());
        return SUCCESS;
    }
    
    public String editAccount() throws Exception {
    
        user = accountBusiness
                .getUserById(accountDetails.getUser().getUserId());
        if (user != null) {
            accountBusiness.updateUserInfo(user);
        }
        return SUCCESS;
    }
}
