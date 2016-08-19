package tms62.action.user.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.CourseBusiness;
import tms62.messages.Messages;
import tms62.model.entity.Courses;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;
import tms62.model.entity.UsersSubjects;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {

    private static final long   serialVersionUID = 1L;
    private CourseBusiness      courseBusiness;
    private List<Courses>       listCourses;
    private Courses             currentCourse;
    private List<UsersCourses>  listUsersCourse;
    private List<UsersSubjects> listSubjectOfUser;
    private UsersCourses        userCourse;
    private List<Users>         listUser;
    private Users               user;
    
    public List<Users> getListUser() {
    
        return listUser;
    }
    
    public void setListUser(List<Users> listUser) {
    
        this.listUser = listUser;
    }
    
    AccountDetails accountDetails = (AccountDetails) SecurityContextHolder
                                          .getContext().getAuthentication()
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
    
    public List<UsersSubjects> getListSubjectOfUser() {

        return listSubjectOfUser;
    }
    
    public void setListSubjectOfUser(List<UsersSubjects> listSubjectOfUser) {

        this.listSubjectOfUser = listSubjectOfUser;
    }
    
    public UsersCourses getUserCourse() {

        return userCourse;
    }
    
    public void setUserCourse(UsersCourses userCourse) {

        this.userCourse = userCourse;
    }
    
    public String viewAllCourse() throws Exception {
    
        user = courseBusiness.getUserById(accountDetails.getUser());
        listCourses = courseBusiness.getListCourseByAccount(user);
        return SUCCESS;
    }
    
    public String viewCourseDetails() {
    
        user = courseBusiness.getUserById(accountDetails.getUser());
        currentCourse = courseBusiness.getCourseById(currentCourse);
        listSubjectOfUser = courseBusiness.getListUserSubject(user,
                currentCourse);
        for (UsersCourses userCourse : user.getListUsersCourses()) {
            if (userCourse.getCourse().getCourseId() == currentCourse
                    .getCourseId()) {
                this.userCourse = userCourse;
                break;
            }
        }
        if (Helpers.isExist(currentCourse))
            return SUCCESS;
        else
            addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public String viewMemberCourse() throws Exception {

        Users user1 = new Users();
        List<Users> listUser = new ArrayList<Users>();
        user1.setUserId(accountDetails.getUser().getUserId());
        listCourses = courseBusiness.getListCourseByAccount(user1);
        while (currentCourse.getCourseId() != 0) {
            System.out.println("Tesst");
            try {
                currentCourse = courseBusiness.getCourseById(currentCourse);
                listUsersCourse = courseBusiness
                        .getUsersCoursesFromCourseId(currentCourse);
                for (UsersCourses uc : listUsersCourse) {
                    user1 = uc.getUser();
                    if (user1 != null)
                        listUser.add(user1);
                }
                currentCourse.setCourseId(0);
                if (listUser != null)
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
