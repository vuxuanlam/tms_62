package tms62.action.json;

import java.util.List;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;

import com.opensymphony.xwork2.ActionSupport;

public class AccountJsonAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    AccountBusiness           accountBusiness;
    List<Users>               listUsers;
    
    public void setAccountBusiness(AccountBusiness accountBusiness) {
    
        this.accountBusiness = accountBusiness;
    }
    
    public List<Users> getListUsers() {
    
        return listUsers;
    }
    
    public String execute() {
    
        listUsers = accountBusiness.getAllUsers();
        return SUCCESS;
    }
}
