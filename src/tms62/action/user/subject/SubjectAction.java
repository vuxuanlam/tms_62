package tms62.action.user.subject;

import tms62.business.SubjectBusiness;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private SubjectBusiness   subjectBusiness;
    private UsersSubjects     userSubject;
    
    public SubjectBusiness getSubjectBusiness() {
    
        return subjectBusiness;
    }
    
    public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
    
        this.subjectBusiness = subjectBusiness;
    }
    
    public UsersSubjects getUserSubject() {
    
        return userSubject;
    }
    
    public void setUserSubject(UsersSubjects userSubject) {
    
        this.userSubject = userSubject;
    }
    
    public String finishSubject() {
    
        if (Helpers.isExist(userSubject)) {
            userSubject = subjectBusiness.finishSubject(userSubject);
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
}
