package tms62.action.admin.course;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.CourseBusiness;
import tms62.constant.DatabaseValue;
import tms62.messages.Messages;
import tms62.model.entity.Courses;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private CourseBusiness    courseBusiness;
    private List<Courses>     listCourses;
    private List<Subjects>    listSubjectNotOfCourse;
    private Courses           currentCourse;
    private Subjects          subject;
    private CoursesSubjects   courseSubject;
    private List<Users>       listUsersNotOfCourse;
    private Users             user;
    private List<Subjects>    listSubjects;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    
    public CourseBusiness getCourseBusiness() {
    
        return courseBusiness;
    }
    
    public void setCourseBusiness(CourseBusiness courseBusiness) {
    
        this.courseBusiness = courseBusiness;
    }
    
    public List<Courses> getListCourses() {
    
        return listCourses;
    }
    
    public void setListCourses(List<Courses> listCourses) {
    
        this.listCourses = listCourses;
    }
    
    public Courses getCurrentCourse() {
    
        return currentCourse;
    }
    
    public void setCurrentCourse(Courses currentCourse) {
    
        this.currentCourse = currentCourse;
    }
    
    public Subjects getSubject() {
    
        return subject;
    }
    
    public void setSubject(Subjects subject) {
    
        this.subject = subject;
    }
    
    public List<Subjects> getListSubjectNotOfCourse() {
    
        return listSubjectNotOfCourse;
    }
    
    public void setListSubjectNotOfCourse(List<Subjects> listSubjectNotOfCourse) {
    
        this.listSubjectNotOfCourse = listSubjectNotOfCourse;
    }
    
    public CoursesSubjects getCourseSubject() {
    
        return courseSubject;
    }
    
    public void setCourseSubject(CoursesSubjects courseSubject) {
    
        this.courseSubject = courseSubject;
    }
    
    public List<Users> getListUsersNotOfCourse() {
    
        return listUsersNotOfCourse;
    }
    
    public void setListUsersNotOfCourse(List<Users> listUsersNotOfCourse) {
    
        this.listUsersNotOfCourse = listUsersNotOfCourse;
    }
    
    public Users getUser() {
    
        return user;
    }
    
    public void setUser(Users user) {
    
        this.user = user;
    }
    
    public List<Subjects> getListSubjects() {
    
        return listSubjects;
    }
    
    public void setListSubjects(List<Subjects> listSubjects) {
    
        this.listSubjects = listSubjects;
    }

    public String viewAllCourse() {
    
        setCurrentUser();
        if (user.getRole() == DatabaseValue.ADMIN) {
            listCourses = courseBusiness.getAllCourses();
        }
        else
            if (user.getRole() == DatabaseValue.SUPERVIOR) {
                listCourses = courseBusiness.getListCourseByAccount(user);
            }
        return SUCCESS;
    }
    
    public String viewCourseDetails() {
    
        currentCourse = courseBusiness.getCourseById(currentCourse);
        listSubjectNotOfCourse = courseBusiness
                .getSubjectNotOfCourse(currentCourse);
        listUsersNotOfCourse = courseBusiness
                .getListUserNotOfCourse(currentCourse);
        if (Helpers.isExist(currentCourse)) {
            return SUCCESS;
        }
        else {
            addActionError(Messages.CONTENT_NOT_FOUND);
            return ERROR;
        }
    }
    
    public String removeSubject() {
    
        if (Helpers.isExist(courseSubject)) {
            courseSubject = courseBusiness.getCourseSubjectById(courseSubject);
            courseBusiness.removeSubject(courseSubject);
        }
        return SUCCESS;
    }
    
    public String addSubject() {
    
        if (Helpers.isExist(currentCourse) && Helpers.isExist(subject)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            subject = courseBusiness.getSubjectById(subject);
            courseBusiness.addSubject(currentCourse, subject);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String addUserToCourse() {
    
        if (Helpers.isExist(currentCourse) && Helpers.isExist(user)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            user = courseBusiness.getUserById(user);
            courseBusiness.addUserToCourse(user, currentCourse);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String removeUserFromCourse() {
    
        if (Helpers.isExist(currentCourse) && Helpers.isExist(user)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            user = courseBusiness.getUserById(user);
            courseBusiness.removeUserFromCourse(user, currentCourse);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String startCourse() {
    
        if (Helpers.isExist(currentCourse)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            courseBusiness.startCourse(currentCourse);
            return SUCCESS;
        }
        addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public String finishCourse() {
    
        if (Helpers.isExist(currentCourse)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            courseBusiness.finishCourse(currentCourse);
            return SUCCESS;
        }
        addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public void setCurrentUser() {
    
        if (Helpers.isNull(user))
            user = new Users();
        user.setUserId(accountDetails.getUserId());
        user = courseBusiness.getUserById(user);
    }
    
    public String createCourse() {
    
        if (listSubjects == null)
            listSubjects = courseBusiness.getSubjects();
        if (Helpers.isExist(currentCourse)) {
            try {
                subject = courseBusiness.getSubjectById(subject);
                courseBusiness.createCourse(currentCourse, subject);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return SUCCESS;
        }
        return SUCCESS;
    }
}
