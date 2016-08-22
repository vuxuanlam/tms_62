package tms62.action.user.subject;

import java.util.List;
import java.util.Map;

import tms62.business.SubjectBusiness;
import tms62.dao.impl.CourseDAOImpl;
import tms62.dao.impl.SubjectDAOImpl;
import tms62.model.entity.Activities;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.model.entity.UsersCourses;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {
    
    private static final long        serialVersionUID = 1L;
    private SubjectBusiness          subjectBusiness;
    private UsersSubjects            userSubject;
    private String                   log;
    private Subjects                 subject;
    private Map<String, List<Tasks>> listTaskOfUser;
    private UsersCourses             userCourse;
    private List<Activities>         listActivities;
    
    public List<Activities> getListActivities() {
    
        return listActivities;
    }
    
    public void setListActivities(List<Activities> listActivities) {
    
        this.listActivities = listActivities;
    }

    public UsersCourses getUserCourse() {
    
        return userCourse;
    }
    
    public void setUserCourse(UsersCourses userCourse) {
    
        this.userCourse = userCourse;
    }

    public Map<String, List<Tasks>> getListTaskOfUser() {
    
        return listTaskOfUser;
    }
    
    public void setListTaskOfUser(Map<String, List<Tasks>> listTaskOfUser) {
    
        this.listTaskOfUser = listTaskOfUser;
    }

    public Subjects getSubject() {
    
        return subject;
    }
    
    public void setSubject(Subjects subject) {
    
        this.subject = subject;
    }

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
            // log finish subject
            log = "Finish Subject ".concat(
                    userSubject.getCourseSubject().getSubject().getName())
                    .concat(" Of Course ".concat(userSubject.getCourseSubject()
                            .getCourse().getName()));
            subjectBusiness.saveActivity(userSubject.getUser(),
                    CourseDAOImpl.NAME, userSubject.getCourseSubject()
                            .getCourse().getCourseId(), log);
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
    
    public String viewSubjectDetails() {
    
        if (Helpers.isExist(userSubject)) {
            Activities activity = new Activities();
            activity.setTargetType(SubjectDAOImpl.NAME);
            userSubject = subjectBusiness.getUserSubjectById(userSubject);
            subject = userSubject.getCourseSubject().getSubject();
            listTaskOfUser = subjectBusiness.getTaskOfUser(userSubject);
            for (UsersCourses userCourse : userSubject.getUser()
                    .getListUsersCourses()) {
                if (userCourse.getCourse().getCourseId() == userSubject
                        .getCourseSubject().getCourse().getCourseId()) {
                    this.userCourse = userCourse;
                    break;
                }
            }
            activity.setTargetId(subject.getSubjectId());
            listActivities = subjectBusiness.getListActivities(activity);
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
}
