package tms62.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tms62.business.SubjectBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.ActivityDAO;
import tms62.dao.CourseSubjectDAO;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.dao.UserSubjectDAO;
import tms62.dao.impl.SubjectDAOImpl;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.CoursesSubjectsTasks;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.model.entity.Users;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;
import tms62.util.Logit2;

public class SubjectBusinessImpl implements SubjectBusiness {

    private SubjectDAO       subjectDAO;
    private TaskDAO          taskDAO;
    private CourseSubjectDAO courseSubjectDAO;
    private UserSubjectDAO   userSubjectDAO;
    private ActivityDAO      activityDAO;
    private static final Logit2 log = Logit2.getInstance(SubjectBusinessImpl.class);

    public ActivityDAO getActivityDAO() {

        return activityDAO;
    }

    public void setActivityDAO(ActivityDAO activityDAO) {
    
        this.activityDAO = activityDAO;
    }

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
            log.error(e);
        }
    }

    @Override
    public List<Subjects> getSubjects() {

        try {
            return subjectDAO.listAll();
        }
        catch (Exception e) {
            log.error(e);
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
            log.error(e);
        }
    }

    @Override
    public void updateSubject(Subjects subject) {

        try {
            subject.setUpdateAt(Helpers.getCurrentTime());
            subjectDAO.update(subject);
        }
        catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public Subjects getSubjectById(Subjects subject) {

        try {
            return subjectDAO.findById(subject.getSubjectId());
        }
        catch (Exception e) {
            log.error(e);
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
            log.error(e);
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
            log.error(e);
        }
    }

    @Override
    public void finishSubject(CoursesSubjects courseSubject) {

        try {
            courseSubject.setStatus(DatabaseValue.FINISH);
            courseSubjectDAO.update(courseSubject);
        }
        catch (Exception e) {
            log.error(e);
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
            log.error(e);
        }
        return userSubject;
    }

    @Override
    public void saveActivity(Users user, int targetId, String log) {

        try {
            activityDAO
                    .saveActivities(user, SubjectDAOImpl.NAME, targetId, log);
        }
        catch (Exception e) {
            SubjectBusinessImpl.log.error(e);
        }
    }

    @Override
    public void saveActivity(Users user, String target, int targetId, String log) {

        try {
            activityDAO.saveActivities(user, target, targetId, log);
        }
        catch (Exception e) {
            SubjectBusinessImpl.log.error(e);
        }
    }

    @Override
    public UsersSubjects getUserSubjectById(UsersSubjects userSubject) {

        try {
            return userSubjectDAO
                    .findById(userSubject.getUserCourseSubjectId());
        }
        catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public Map<String, List<Tasks>> getTaskOfUser(UsersSubjects userSubject) {

        Map<String, List<Tasks>> mapTaskOfUser = new HashMap<String, List<Tasks>>();
        List<CoursesSubjectsTasks> listCourseSubjectTask;
        List<Tasks> listTask;
        List<Tasks> listTaskFinished = new ArrayList<Tasks>();
        List<Tasks> listTaskUnfinish = new ArrayList<Tasks>();
        boolean isAvalible = false;
        try {
            listCourseSubjectTask = userSubject.getListCourseSubjectTask();
            listTask = userSubject.getCourseSubject().getSubject()
                    .getListTasks();
            for (Tasks task : listTask) {
                for (CoursesSubjectsTasks courseSubjectTask : listCourseSubjectTask) {
                    if (courseSubjectTask.getUserTask().getTask().getTaskId() == task
                            .getTaskId()) {
                        isAvalible = true;
                        break;
                    }
                }
                if (isAvalible) {
                    listTaskFinished.add(task);
                    isAvalible = false;
                }
                else {
                    listTaskUnfinish.add(task);
                }
            }
            mapTaskOfUser.put("listTaskFinished", listTaskFinished);
            mapTaskOfUser.put("listTaskUnfinish", listTaskUnfinish);
            return mapTaskOfUser;
        }
        catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
