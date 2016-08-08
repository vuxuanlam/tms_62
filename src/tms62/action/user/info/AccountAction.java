package tms62.action.user.info;

import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;

public class AccountAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private AccountBusiness   accountBusiness;
    private SessionMap        session;
    private Users             currentUser;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
            .getContext().getAuthentication().getPrincipal();
    
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
        
        currentUser = accountBusiness.getUserById(accountDetails.getUserId());
        return SUCCESS;
    }
    
    public String editAccount() throws Exception {

        return SUCCESS;
    }
}
