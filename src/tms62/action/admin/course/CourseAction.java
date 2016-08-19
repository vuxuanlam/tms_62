package tms62.action.admin.course;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.CourseBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.impl.CourseDAOImpl;
import tms62.dao.impl.UserDAOImpl;
import tms62.messages.Messages;
import tms62.model.entity.Activities;
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
    private boolean           update           = false;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    private String            log;
    private List<Activities>  listActivities;
    
    public List<Activities> getListActivities() {
    
        return listActivities;
    }

    public void setListActivities(List<Activities> listActivities) {
    
        this.listActivities = listActivities;
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
    
    public String viewAllCourse() throws Exception {
    
        user = courseBusiness.getUserById(accountDetails.getUser());
        if (user.getRole() == DatabaseValue.ADMIN) {
            // list course
            listCourses = courseBusiness.getAllCourses();
            // list activities
            listActivities = courseBusiness
                    .getListActivities(CourseDAOImpl.NAME);
        }
        else
            if (user.getRole() == DatabaseValue.SUPERVIOR) {
                // list coutse of supervior
                listCourses = courseBusiness.getListCourseByAccount(user);
            }
        return SUCCESS;
    }
    
    public boolean isUpdate() {

        return update;
    }
    
    public void setUpdate(boolean update) {

        this.update = update;
    }
    
    public String viewCourseDetails() {
    
        Activities activity = new Activities();
        currentCourse = courseBusiness.getCourseById(currentCourse);
        listSubjectNotOfCourse = courseBusiness
                .getSubjectNotOfCourse(currentCourse);
        listUsersNotOfCourse = courseBusiness
                .getListUserNotOfCourse(currentCourse);
        // get activity
        activity.setTargetType(CourseDAOImpl.NAME);
        activity.setTargetId(currentCourse.getCourseId());
        listActivities = courseBusiness.getListActivities(activity);
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
            // Save activity
            log = "Delete Subject ".concat(courseSubject.getSubject().getName()
                    .concat(" From Course")
                    .concat(courseSubject.getCourse().getName()));
            courseBusiness.saveActivity(accountDetails.getUser(), courseSubject
                    .getCourse().getCourseId(), log);
        }
        return SUCCESS;
    }
    
    public String addSubject() {

        if (Helpers.isExist(currentCourse) && Helpers.isExist(subject)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            subject = courseBusiness.getSubjectById(subject);
            courseBusiness.addSubject(currentCourse, subject);
            log = "Add Subject ".concat(subject.getName().concat("To Course")
                    .concat(currentCourse.getName()));
            courseBusiness.saveActivity(accountDetails.getUser(),
                    currentCourse.getCourseId(), log);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String addUserToCourse() {

        if (Helpers.isExist(currentCourse) && Helpers.isExist(user)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            user = courseBusiness.getUserById(user);
            courseBusiness.addUserToCourse(user, currentCourse);
            // Log to Course
            log = "Add User ".concat(user.getEmail().concat(" to Course")
                    .concat(currentCourse.getName()));
            courseBusiness.saveActivity(accountDetails.getUser(),
                    currentCourse.getCourseId(), log);
            // Log to user
            log = "User ".concat(user.getEmail().concat(
                    " was Add To Course ".concat(currentCourse.getName())));
            courseBusiness.saveActivity(accountDetails.getUser(),
                    UserDAOImpl.NAME, user.getUserId(), log);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String removeUserFromCourse() {
    
        if (Helpers.isExist(currentCourse) && Helpers.isExist(user)) {
            currentCourse = courseBusiness.getCourseById(currentCourse);
            user = courseBusiness.getUserById(user);
            courseBusiness.removeUserFromCourse(user, currentCourse);
            // Log to course
            log = "Remove User ".concat(user.getEmail().concat(" From Course ")
                    .concat(currentCourse.getName()));
            courseBusiness.saveActivity(accountDetails.getUser(),
                    currentCourse.getCourseId(), log);
            // Log to User
            log = "User "
                    .concat(user.getEmail().concat(
                            " was Remove From Course ".concat(currentCourse
                                    .getName())));
            courseBusiness.saveActivity(accountDetails.getUser(),
                    UserDAOImpl.NAME, user.getUserId(), log);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String startCourse() {
    
        if (Helpers.isExist(currentCourse)) {
            // start
            user = courseBusiness.getUserById(accountDetails.getUser());
            currentCourse = courseBusiness.getCourseById(currentCourse);
            courseBusiness.startCourse(currentCourse);
            // Log start course
            log = "Start Course ".concat(currentCourse.getName());
            courseBusiness.saveActivity(user, currentCourse.getCourseId(), log);
            return SUCCESS;
        }
        addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public String finishCourse() {

        if (Helpers.isExist(currentCourse)) {
            // finish course
            user = courseBusiness.getUserById(accountDetails.getUser());
            currentCourse = courseBusiness.getCourseById(currentCourse);
            courseBusiness.finishCourse(currentCourse);
            // Log finish course
            log = "Finish course ".concat(currentCourse.getName());
            courseBusiness.saveActivity(user, currentCourse.getCourseId(), log);
            return SUCCESS;
        }
        addActionError(Messages.CONTENT_NOT_FOUND);
        return ERROR;
    }
    
    public String createCourse() {

        listSubjects = courseBusiness.getSubjects();
        if (Helpers.isExist(currentCourse)) {
            try {
                // create course
                subject = courseBusiness.getSubjectById(subject);
                courseBusiness.createCourse(currentCourse, subject);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return SUCCESS;
    }
    
    public String deleteCourse() {

        if (Helpers.isExist(currentCourse)) {
            // delete course
            currentCourse = courseBusiness.getCourseById(currentCourse);
            courseBusiness.removeCourse(currentCourse);
            addActionMessage(Messages.DELETE_SUCCESS);
            return SUCCESS;
        }
        return ERROR;
    }
    
    public String updateCourse() {

        if (Helpers.isExist(currentCourse)) {
            if (update) {
                courseBusiness.updateCourse(currentCourse);
            }
            currentCourse = courseBusiness.getCourseById(currentCourse);
            return SUCCESS;
        }
        else
            return ERROR;
    }
}
