package tms62.business.impl;

import java.util.ArrayList;
import java.util.List;

import tms62.business.CourseBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.ActivityDAO;
import tms62.dao.CourseDAO;
import tms62.dao.CourseSubjectDAO;
import tms62.dao.SubjectDAO;
import tms62.dao.UserCourseDAO;
import tms62.dao.UserDAO;
import tms62.dao.UserSubjectDAO;
import tms62.dao.impl.CourseDAOImpl;
import tms62.model.entity.Courses;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;

public class CourseBusinessImpl implements CourseBusiness {
    
    private CourseDAO        courseDAO;
    private UserCourseDAO    userCourseDAO;
    private UserDAO          userDAO;
    private SubjectDAO       subjectDAO;
    private CourseSubjectDAO courseSubjectDAO;
    private UserSubjectDAO   userSubjectDAO;
    private ActivityDAO      activityDAO;
    
    public ActivityDAO getActivityDAO() {
    
        return activityDAO;
    }
    
    public void setActivityDAO(ActivityDAO activityDAO) {
    
        this.activityDAO = activityDAO;
    }

    public UserDAO getUserDAO() {

        return userDAO;
    }
    
    public void setUserDAO(UserDAO userDAO) {

        this.userDAO = userDAO;
    }
    
    public CourseDAO getCourseDAO() {

        return courseDAO;
    }
    
    public void setCourseDAO(CourseDAO courseDAO) {

        this.courseDAO = courseDAO;
    }
    
    public UserCourseDAO getUserCourseDAO() {

        return userCourseDAO;
    }
    
    public SubjectDAO getSubjectDAO() {

        return subjectDAO;
    }
    
    public void setSubjectDAO(SubjectDAO subjectDAO) {

        this.subjectDAO = subjectDAO;
    }
    
    public void setUserCourseDAO(UserCourseDAO userCourseDAO) {

        this.userCourseDAO = userCourseDAO;
    }
    
    public CourseSubjectDAO getCourseSubjectDAO() {

        return courseSubjectDAO;
    }
    
    public void setCourseSubjectDAO(CourseSubjectDAO courseSubjectDAO) {

        this.courseSubjectDAO = courseSubjectDAO;
    }
    
    public UserSubjectDAO getUserSubjectDAO() {

        return userSubjectDAO;
    }
    
    public void setUserSubjectDAO(UserSubjectDAO userSubjectDAO) {

        this.userSubjectDAO = userSubjectDAO;
    }
    
    @Override
    public List<Courses> getListCourseByAccount(Users user) {

        List<Courses> listCourse = new ArrayList<Courses>();
        try {
            for (UsersCourses userCourse : user.getListUsersCourses()) {
                if (user.getRole() == DatabaseValue.USER) {
                    userCourse.getCourse().setStatus(userCourse.getStatus());
                }
                listCourse.add(userCourse.getCourse());
            }
            return listCourse;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Courses> getAllCourses() {

        try {
            return courseDAO.listAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Courses getCourseById(Courses course) {

        try {
            return courseDAO.findById(course.getCourseId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Subjects> getSubjectNotOfCourse(Courses course) {

        List<Subjects> listSubjects;
        List<Subjects> listSubjectOfCourse = new ArrayList<Subjects>();
        try {
            listSubjects = subjectDAO.listAll();
            for (Subjects subject : listSubjects) {
                for (CoursesSubjects courseSubject : course
                        .getListCoursesSubjects()) {
                    if (subject.getSubjectId() == courseSubject.getSubject()
                            .getSubjectId()) {
                        listSubjectOfCourse.add(subject);
                    }
                }
            }
            listSubjects.removeAll(listSubjectOfCourse);
            return listSubjects;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void removeSubject(CoursesSubjects courseSubject) {

        try {
            courseSubjectDAO.delete(courseSubject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public CoursesSubjects getCourseSubjectById(CoursesSubjects courseSubject) {

        try {
            return courseSubjectDAO
                    .findById(courseSubject.getCourseSubjectId());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Subjects getSubjectById(Subjects subject) {

        try {
            return subjectDAO.findById(subject.getSubjectId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void addSubject(Courses course, Subjects subject) {

        UsersSubjects userSubject;
        CoursesSubjects courseSubject = new CoursesSubjects();
        courseSubject.setCourse(course);
        courseSubject.setSubject(subject);
        try {
            courseSubjectDAO.save(courseSubject);
            for (UsersCourses userCourse : course.getListUsersCourses()) {
                if (userCourse.getCourse().getStatus() == DatabaseValue.OPEN
                        && userCourse.getUser().getRole() != DatabaseValue.SUPERVIOR) {
                    userSubject = new UsersSubjects();
                    userSubject.setUser(userCourse.getUser());
                    userSubject.setCourseSubject(courseSubject);
                    userSubjectDAO.save(userSubject);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Users> getListUserNotOfCourse(Courses course) {

        List<Users> listUserOfCourse = new ArrayList<Users>();
        List<Users> listUser;
        try {
            listUser = userDAO.listAll();
            for (Users user : listUser) {
                if (user.getRole() == DatabaseValue.ADMIN)
                    listUserOfCourse.add(user);
                for (UsersCourses userCourse : course.getListUsersCourses())
                    if (userCourse.getUser().getUserId() == user.getUserId())
                        listUserOfCourse.add(user);
            }
            listUser.removeAll(listUserOfCourse);
            return listUser;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Users getUserById(Users user) {

        try {
            return userDAO.findById(user.getUserId());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void addUserToCourse(Users user, Courses course) {

        boolean check = false;
        UsersCourses userCourse = new UsersCourses();
        userCourse.setCourse(course);
        userCourse.setUser(user);
        for (UsersCourses userCourseTemp : user.getListUsersCourses()) {
            if (userCourseTemp.getStatus() == DatabaseValue.OPEN) {
                check = true;
            }
        }
        if (check == false) {
            userCourse.setStatus(course.getStatus());
        }
        try {
            userCourseDAO.save(userCourse);
            if (userCourse.getCourse().getStatus() == DatabaseValue.OPEN
                    && userCourse.getUser().getRole() != DatabaseValue.SUPERVIOR)
                addSubjectForUser(userCourse);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void removeUserFromCourse(Users user, Courses course) {

        try {
            for (UsersCourses userCourse : user.getListUsersCourses()) {
                if (userCourse.getCourse().getCourseId() == course
                        .getCourseId()) {
                    userCourseDAO.delete(userCourse);
                    break;
                }
            }
            for (UsersSubjects userSubject : user.getListUsersSubjects()) {
                for (CoursesSubjects courseSubject : course
                        .getListCoursesSubjects()) {
                    if (courseSubject.getCourseSubjectId() == userSubject
                            .getCourseSubject().getCourseSubjectId()) {
                        userSubjectDAO.delete(userSubject);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void startCourse(Courses course) {

        Boolean check;
        try {
            for (UsersCourses userCourse : course.getListUsersCourses()) {
                check = false;
                for (UsersCourses userCourseTemp : userCourse.getUser()
                        .getListUsersCourses()) {
                    if (userCourseTemp.getStatus() == DatabaseValue.OPEN) {
                        check = true;
                        break;
                    }
                }
                if (check == false)
                    userCourse.setStatus(DatabaseValue.OPEN);
                if (userCourse.getUser().getRole() != DatabaseValue.SUPERVIOR)
                    addSubjectForUser(userCourse);
            }
            course.setStatus(DatabaseValue.OPEN);
            courseDAO.update(course);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addSubjectForUser(UsersCourses userCourse) {

        UsersSubjects userSubject;
        for (CoursesSubjects courseSubject : userCourse.getCourse()
                .getListCoursesSubjects()) {
            userSubject = new UsersSubjects();
            userSubject.setUser(userCourse.getUser());
            userSubject.setCourseSubject(courseSubject);
            if (userCourse.getStatus() == DatabaseValue.OPEN
                    && courseSubject.getStatus() == DatabaseValue.OPEN) {
                userSubject.setStatus(DatabaseValue.OPEN);
            }
            try {
                userSubjectDAO.save(userSubject);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void finishCourse(Courses course) {

        try {
            course.setStatus(DatabaseValue.FINISH);
            for (CoursesSubjects courseSubject : course
                    .getListCoursesSubjects()) {
                courseSubject.setStatus(DatabaseValue.FINISH);
            }
            for (UsersCourses userCourse : course.getListUsersCourses()) {
                userCourse.setStatus(DatabaseValue.FINISH);
            }
            courseDAO.update(course);
            activeOtherCourseForUsers(course);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Courses createCourse(Courses course, Subjects subject) {

        try {
            List<CoursesSubjects> listCourseSubject = new ArrayList<CoursesSubjects>();
            CoursesSubjects courseSubject = new CoursesSubjects();
            courseSubject.setCourse(course);
            courseSubject.setSubject(subject);
            listCourseSubject.add(courseSubject);
            course.setListCoursesSubjects(listCourseSubject);
            courseDAO.save(course);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Subjects> getSubjects() {

        try {
            return subjectDAO.listAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<UsersCourses> getUsersCoursesFromCourseId(Courses course)
            throws Exception {

        try {
            return course.getListUsersCourses();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void activeOtherCourseForUsers(Courses course) {

        try {
            for (UsersCourses userCourse : course.getListUsersCourses()) {
                if (userCourse.getUser().getRole() != DatabaseValue.SUPERVIOR) {
                    for (UsersCourses userCourseOfUser : userCourse.getUser()
                            .getListUsersCourses()) {
                        if (userCourseOfUser.getStatus() == DatabaseValue.CLOSE
                                && userCourseOfUser.getCourse().getStatus() == DatabaseValue.OPEN) {
                            userCourseOfUser.setStatus(DatabaseValue.OPEN);
                            userCourseDAO.update(userCourseOfUser);
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<UsersSubjects> getListUserSubject(Users user, Courses course) {

        List<UsersSubjects> listUserSubject = new ArrayList<UsersSubjects>();
        try {
            for (CoursesSubjects courseSubject : course
                    .getListCoursesSubjects()) {
                for (UsersSubjects userSubject : user.getListUsersSubjects()) {
                    if (courseSubject.getCourseSubjectId() == userSubject
                            .getCourseSubject().getCourseSubjectId()) {
                        listUserSubject.add(userSubject);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return listUserSubject;
    }
    
    public void removeCourse(Courses course) {

        try {
            courseDAO.delete(course);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateCourse(Courses course) {

        try {
            course.setUpdateAt(Helpers.getCurrentTime());
            courseDAO.update(course);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void saveActivity(Users user, int targetId, String log) {
    
        try {
            activityDAO.saveActivities(user, CourseDAOImpl.NAME, targetId, log);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void saveActivity(Users user, String target, int targetId, String log) {
    
        try {
            activityDAO.saveActivities(user, target, targetId, log);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
