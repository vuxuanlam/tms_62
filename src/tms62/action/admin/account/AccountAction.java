package tms62.action.admin.account;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.AccountBusiness;
import tms62.dao.impl.UserDAOImpl;
import tms62.model.entity.Activities;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    AccountBusiness           accountBusiness;
    List<Users>               listAccounts;
    Users                     userTemp;
    Users                     currentUser;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    private List<Activities>  listActivities;
    
    public List<Activities> getListActivities() {
    
        return listActivities;
    }
    
    public void setListActivities(List<Activities> listActivities) {
    
        this.listActivities = listActivities;
    }

    public Users getCurrentUser() {

        return currentUser;
    }
    
    public void setCurrentUser(Users currentUser) {

        this.currentUser = currentUser;
    }
    
    public Users getUserTemp() {

        return userTemp;
    }
    
    public void setUserTemp(Users userTemp) {

        this.userTemp = userTemp;
    }
    
    public AccountBusiness getAccountBusiness() {

        return accountBusiness;
    }
    
    public void setAccountBusiness(AccountBusiness accountBusiness) {

        this.accountBusiness = accountBusiness;
    }
    
    public List<Users> getListAccounts() {

        return listAccounts;
    }
    
    public void setListAccounts(List<Users> listAccounts) {

        this.listAccounts = listAccounts;
    }
    
    public String viewAllAccount() {

        listAccounts = accountBusiness.getAllUsers();
        listActivities = accountBusiness.getListActivities(UserDAOImpl.NAME);
        return SUCCESS;
    }
    
    public String createAccount() {
    
        String log;
        if (userTemp != null) {
            accountBusiness.createAccount(userTemp);
            log = "Create Account ".concat(userTemp.getName());
            // Save activity
            accountBusiness.saveActivity(accountDetails.getUser(),
                    userTemp.getUserId(), log);
            return SUCCESS;
        }
        return SUCCESS;
    }
    
    public String viewAccount() {
    
        currentUser = accountDetails.getUser();
        return SUCCESS;
    }
    
    public String deleteAccount() {

        listAccounts = accountBusiness.getAllUsers();
        if (currentUser.getUserId() != 0
                && currentUser.getUserId() != accountDetails.getUser()
                        .getUserId()) {
            boolean result = false;
            result = accountBusiness.deleteAccount(accountBusiness
                    .getUserById(currentUser.getUserId()));
            if (result == true)
                return SUCCESS;
            else
                return ERROR;
        }
        return SUCCESS;
    }
    
    public String editAccount() {

        listAccounts = accountBusiness.getAllUsers();
        if (currentUser.getUserId() != 0) {
            boolean result = false;
            result = accountBusiness.updateAccount(currentUser);
            if (result == true)
                return SUCCESS;
            else
                return ERROR;
        }
        return SUCCESS;
    }
}
