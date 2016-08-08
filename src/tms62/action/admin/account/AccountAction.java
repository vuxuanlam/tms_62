package tms62.action.admin.account;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
    
    
    private static final long serialVersionUID = 1L;
    AccountBusiness           accountBusiness;
    List<Users>               listAccounts;
    Users                     userTemp;
    Users                     currentUser;
    
    public Users getCurrentUser() {
        
        return currentUser;
    }
    
    public void setCurrentUser(Users currentUser) {
        
        this.currentUser = currentUser;
    }
    
    private AccountDetails accountDetails = (AccountDetails) SecurityContextHolder
            .getContext().getAuthentication().getPrincipal();
    
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
        return SUCCESS;
    }
    
    public String createAccount() {
        
        if (userTemp != null) {
            accountBusiness.createAccount(userTemp);
            return SUCCESS;
        }
        return SUCCESS;
    }
    
    public String viewAccount() {
        
        currentUser = accountBusiness.getUserById(accountDetails.getUserId());
        return SUCCESS;
    }
}
