package tms62.action.user.course;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.CourseBusiness;
import tms62.messages.Messages;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
    
    private static final long  serialVersionUID = 1L;
    private CourseBusiness     courseBusiness;
    private List<Courses>      listCourses;
    private Courses            currentCourse;
    private List<UsersCourses> listUsersCourse;
    AccountDetails             accountDetails   = (AccountDetails) SecurityContextHolder
                                                        .getContext()
                                                        .getAuthentication()
                                                        .getPrincipal();
    
    public List<UsersCourses> getlistUsersCourse() {

        return listUsersCourse;
    }
    
    public void setListUsers(List<UsersCourses> listUsersCourse) {

        this.listUsersCourse = listUsersCourse;
    }
    
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
    
    public String viewAllCourse() {

        Users user = new Users();
        user.setUserId(accountDetails.getUserId());
        user = courseBusiness.getUserById(user);
        listCourses = courseBusiness.getListCourseByAccount(user);
        return SUCCESS;
    }
    
    public String viewCourseDetails() {

        currentCourse = courseBusiness.getCourseById(currentCourse);
        if (Helpers.isExist(currentCourse))
            return SUCCESS;
        else
            addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public String viewMemberCourse() throws Exception {

        Users user = new Users();
        user.setUserId(accountDetails.getUserId());
        listCourses = courseBusiness.getListCourseByAccount(user);
        if (currentCourse.getCourseId() != 0) {
            try {
                currentCourse = courseBusiness.getCourseById(currentCourse);
                listUsersCourse = courseBusiness
                        .getUsersCoursesFromCourseId(currentCourse);
                return SUCCESS;
            }
            catch (Exception e) {
                e.printStackTrace();
                return ERROR;
            }
        }
        return SUCCESS;
    }
}
