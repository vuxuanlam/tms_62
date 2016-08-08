package tms62.business.impl;

import java.util.List;

import tms62.business.SubjectBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.CourseSubjectDAO;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.dao.UserSubjectDAO;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;

public class SubjectBusinessImpl implements SubjectBusiness {
    
    private SubjectDAO       subjectDAO;
    private TaskDAO          taskDAO;
    private CourseSubjectDAO courseSubjectDAO;
    private UserSubjectDAO   userSubjectDAO;
    
    public SubjectDAO getSubjectDAO() {
    
        return subjectDAO;
    }
    
    public void setSubjectDAO(SubjectDAO subjectDAO) {
    
        this.subjectDAO = subjectDAO;
    }
    
    public TaskDAO getTaskDAO() {
    
        return taskDAO;
    }
    
    public void setTaskDAO(TaskDAO taskDAO) {
    
        this.taskDAO = taskDAO;
    }
    
    @Override
    public void createSubject(Subjects subject) {
    
        Subjects tempSubject;
        try {
            tempSubject = subjectDAO.findSubjectByName(subject);
            if (Helpers.isNull(tempSubject)) {
                subjectDAO.save(subject);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
    public void removeSubject(Subjects subject) {
    
        try {
            subjectDAO.delete(subject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateSubject(Subjects subject) {
    
        try {
            subject.setUpdateAt(Helpers.getCurrentTime());
            subjectDAO.update(subject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Subjects getSubjectById(Subjects subject) {
    
        try {
            return subjectDAO.findById(subject.getSubjectId());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public CoursesSubjects getCourseSubjecttById(CoursesSubjects courseSubject) {
    
        try {
            return courseSubjectDAO
                    .findById(courseSubject.getCourseSubjectId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void startSubject(CoursesSubjects courseSubject) {
    
        try {
            courseSubject.setStatus(DatabaseValue.OPEN);
            courseSubjectDAO.update(courseSubject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void finishSubject(CoursesSubjects courseSubject) {
    
        try {
            courseSubject.setStatus(DatabaseValue.FINISH);
            courseSubjectDAO.update(courseSubject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public UsersSubjects finishSubject(UsersSubjects userSubject) {
    
        try {
            userSubject = userSubjectDAO.findById(userSubject
                    .getUserCourseSubjectId());
            userSubject.setStatus(DatabaseValue.FINISH);
            userSubjectDAO.update(userSubject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return userSubject;
    }
}
