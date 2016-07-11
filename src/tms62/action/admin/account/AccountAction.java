package tms62.action.admin.account;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.AdminBusiness;
import tms62.constant.message.PermissionMessage;
import tms62.constant.value.DatabaseValue;
import tms62.model.entity.Users;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport implements SessionAware {

  SessionMap   session;
  AdminBusiness adminBusiness;
  List<Users>  listAccounts;

  @Override
  public void setSession(Map<String, Object> session) {

    this.session = (SessionMap) session;
  }

  public AdminBusiness getAdminBusiness() {

    return adminBusiness;
  }

  public void setAdminBusiness(AdminBusiness adminBusiness) {

    this.adminBusiness = adminBusiness;
  }

  public List<Users> getListAccounts() {

    return listAccounts;
  }

  public void setListAccounts(List<Users> listAccounts) {

    this.listAccounts = listAccounts;
  }

  public String viewAllAccount() {

    Users currentUser = Helpers.getCurrentUserFromSession();
    if (Helpers.isExist(currentUser)
        && currentUser.isRole() == DatabaseValue.ADMIN) {
      listAccounts = adminBusiness.getAllUsers();
      return SUCCESS;
    }
    addActionError(PermissionMessage.DEFAULT);
    return ERROR;
  }
}
