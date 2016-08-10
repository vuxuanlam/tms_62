package tms62.action.user.subject;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.SubjectBusiness;
import tms62.dao.impl.CourseDAOImpl;
import tms62.model.entity.UsersSubjects;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private SubjectBusiness   subjectBusiness;
    private UsersSubjects     userSubject;
    private String            log;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    
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
            log = "Finish Subject ".concat(
                    userSubject.getCourseSubject().getSubject().getName())
                    .concat(" Of Course ".concat(userSubject.getCourseSubject()
                            .getCourse().getName()));
            subjectBusiness.saveActivity(accountDetails.getUser(),
                    CourseDAOImpl.NAME, userSubject.getCourseSubject()
                            .getCourse().getCourseId(), log);
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
}
