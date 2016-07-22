package tms62.action.user.course;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.CourseBusiness;
import tms62.constant.message.WrongAccess;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private CourseBusiness    courseBusiness;
    private List<Courses>     listCourses;
    private Courses           currentCourse;
    private Users             user;
    AccountDetails            accountDetails   = (AccountDetails) SecurityContextHolder
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
    
    public void setListCourses(List<Courses> listMyCourses) {
    
        this.listCourses = listMyCourses;
    }
    
    public Courses getCurrentCourse() {
    
        return currentCourse;
    }
    
    public void setCurrentCourse(Courses currentCourse) {
    
        this.currentCourse = currentCourse;
    }
    
    public Users getUser() {
    
        return user;
    }
    
    public void setUser(Users user) {
    
        this.user = user;
    }

    public String viewAllCourse() {
    
        setCurrentUser();
        listCourses = courseBusiness.getListCourseByAccount(user);
        return SUCCESS;
    }
    
    public String viewCourseDetails() {
    
        currentCourse = courseBusiness.getCourseById(currentCourse);
        if (Helpers.isExist(currentCourse)) {
            return SUCCESS;
        }
        else
            addActionError(WrongAccess.NOTFOUND);
        return ERROR;
    }
    
    public void setCurrentUser() {
    
        if (Helpers.isNull(user))
            user = new Users();
        user.setUserId(accountDetails.getUserId());
        user = courseBusiness.getUserById(user);
    }
}
