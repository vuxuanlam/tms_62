package tms62.action.user.info;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.AccountBusiness;
import tms62.constant.DatabaseValue;
import tms62.model.entity.Users;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport implements SessionAware {
    
    private static final long serialVersionUID = 1L;
    private AccountBusiness   accountBusiness;
    private SessionMap        session;
    private Users             user;  
    public AccountBusiness getAccountBusiness() {
        return accountBusiness;
    }  
    public void setAccountBusiness(AccountBusiness accountBusiness) {
        this.accountBusiness = accountBusiness;
    }    
    public Users getUser() {
        return user;
    }    
    public void setUser(Users user) {
        this.user = user;
    }   
    public String viewAccount() {
        Users currentUser = Helpers.getCurrentUserFromSession();
        if (Helpers.isExist(currentUser)
                && currentUser.getRole() == DatabaseValue.USER) {
            this.user = currentUser;
            System.out.println(user.getEmail());
            return SUCCESS;
        }
        return ERROR;
    }    
    public String editAccount() throws Exception {
        Users currentUser = Helpers.getCurrentUserFromSession();
        if (Helpers.isExist(currentUser)
                && currentUser.getRole() == DatabaseValue.USER) {
            if (Helpers.isExist(user))
                accountBusiness.updateUserInfo(user);
            return SUCCESS;
        }
        return ERROR;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        // TODO Auto-generated method stub
        this.session = (SessionMap) session;
    }
}
