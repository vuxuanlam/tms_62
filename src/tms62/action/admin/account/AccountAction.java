package tms62.action.admin.account;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.AccountBusiness;
import tms62.model.entity.Users;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport implements SessionAware {

  SessionMap      session;
  AccountBusiness accountBusiness;

  public AccountBusiness getAccountBusiness() {

    return accountBusiness;
  }

  public void setAccountBusiness(AccountBusiness accountBusiness) {

    this.accountBusiness = accountBusiness;
  }

  List<Users> listAccounts;

  @Override
  public void setSession(Map<String, Object> session) {

    this.session = (SessionMap) session;
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
}
