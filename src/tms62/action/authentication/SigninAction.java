package tms62.action.authentication;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tms62.business.AuthenticationBusiness;
import tms62.constant.message.AuthenticationMessage;
import tms62.constant.value.SessionValue;
import tms62.model.entity.Users;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SigninAction extends ActionSupport implements SessionAware {

  /**
   * 
   */
  private static final long      serialVersionUID = 1L;
  private Users                  user;
  private AuthenticationBusiness authenticationBusiness;
  private SessionMap             session;

  public Users getUser() {

    return user;
  }

  public void setUser(Users user) {

    this.user = user;
  }

  public AuthenticationBusiness getAuthenticationBusiness() {

    return authenticationBusiness;
  }

  public void setAuthenticationBusiness(
      AuthenticationBusiness authenticationBusiness) {

    this.authenticationBusiness = authenticationBusiness;
  }

  @Override
  public void setSession(Map<String, Object> session) {

    this.session = (SessionMap) session;
  }

  public String signinPage() {

    if (Helpers.isEmpty(session))
      return SUCCESS;
    else
      return ERROR;

  }

  public String signin() {

    Users currentUser;
    if (!Helpers.isEmpty(session))
      return NONE;
    if (Helpers.isExist(user)) {
      currentUser = authenticationBusiness.checkUserSignin(user);
      if (Helpers.isExist(currentUser)) {
        addActionMessage(AuthenticationMessage.SIGNIN_SUCCESS);
        session.put(SessionValue.CURRENT_USER, currentUser);
        return SUCCESS;
      }
    }
    addActionError(AuthenticationMessage.SIGNIN_ERROR);
    return ERROR;
  }

  public String signout() {

    if (!Helpers.isEmpty(session))
      session.invalidate();
    return SUCCESS;
  }
}
