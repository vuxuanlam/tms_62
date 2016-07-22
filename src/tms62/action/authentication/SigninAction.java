package tms62.action.authentication;

import tms62.constant.message.AuthenticationMessage;

import com.opensymphony.xwork2.ActionSupport;

public class SigninAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private Boolean           error;
    
    public Boolean getError() {
    
        return error;
    }
    
    public void setError(Boolean error) {
    
        this.error = error;
    }
    
    public String signin() {
    
        if (error) {
            addActionError(AuthenticationMessage.SIGNIN_ERROR);
        }
        else
            addActionMessage(AuthenticationMessage.SIGNIN_SUCCESS);
        return SUCCESS;
    }
}
