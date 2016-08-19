package tms62.business.impl;

import java.util.ArrayList;
import java.util.List;

import tms62.business.TaskBusiness;
import tms62.constant.DatabaseValue;
import tms62.dao.ActivityDAO;
import tms62.dao.CourseSubjectTaskDAO;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.dao.UserSubjectDAO;
import tms62.dao.UserTaskDAO;
import tms62.dao.impl.TaskDAOImpl;
import tms62.model.entity.CoursesSubjectsTasks;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.model.entity.Users;
import tms62.model.entity.UsersSubjects;
import tms62.model.entity.UsersTasks;
import tms62.util.Logit2;

public class TaskBusinessImpl implements TaskBusiness {

    private TaskDAO              taskDAO;
    private SubjectDAO           subjectDAO;
    private ActivityDAO          activityDAO;
    private UserSubjectDAO       userSubjectDAO;
    private CourseSubjectTaskDAO courseSubjectTaskDAO;
    private UserTaskDAO          userTaskDAO;
    private static final Logit2  log = Logit2.getInstance(TaskDAOImpl.class);

    public UserTaskDAO getUserTaskDAO() {

        return userTaskDAO;
    }

    public void setUserTaskDAO(UserTaskDAO userTaskDAO) {

        this.userTaskDAO = userTaskDAO;
    }

    public CourseSubjectTaskDAO getCourseSubjectTaskDAO() {

        return courseSubjectTaskDAO;
    }

    public void setCourseSubjectTaskDAO(
            CourseSubjectTaskDAO courseSubjectTaskDAO) {
    
        this.courseSubjectTaskDAO = courseSubjectTaskDAO;
    }

    public UserSubjectDAO getUserSubjectDAO() {

        return userSubjectDAO;
    }

    public void setUserSubjectDAO(UserSubjectDAO userSubjectDAO) {

        this.userSubjectDAO = userSubjectDAO;
    }

    public ActivityDAO getActivityDAO() {

        return activityDAO;
    }

    public void setActivityDAO(ActivityDAO activityDAO) {

        this.activityDAO = activityDAO;
    }

    public TaskDAO getTaskDAO() {

        return taskDAO;
    }

    public void setTaskDAO(TaskDAO taskDAO) {

        this.taskDAO = taskDAO;
    }

    public SubjectDAO getSubjectDAO() {

        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {

        this.subjectDAO = subjectDAO;
    }

    @Override
    public void removeTask(Tasks task) {

        try {
            taskDAO.delete(task);
        }
        catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public Tasks getTaskById(Tasks task) {

        try {
            return taskDAO.findById(task.getTaskId());
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public void createTask(Tasks task) {

        try {
            taskDAO.save(task);
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
    public void saveActivity(Users user, int targetId, String log) {

        try {
            activityDAO.saveActivities(user, TaskDAOImpl.NAME, targetId, log);
        }
        catch (Exception e) {
            TaskBusinessImpl.log.error(e);
        }
    }

    @Override
    public void saveActivity(Users user, String target, int targetId, String log) {

        try {
            activityDAO.saveActivities(user, target, targetId, log);
        }
        catch (Exception e) {
            TaskBusinessImpl.log.error(e);
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
        }
        return null;
    }

    @Override
    public void finishTask(UsersSubjects userSubject, Tasks task) {

        UsersTasks userTask = new UsersTasks();
        List<CoursesSubjectsTasks> listCourseSubjectTask = new ArrayList<CoursesSubjectsTasks>();
        CoursesSubjectsTasks courseSubjectTask = new CoursesSubjectsTasks();
        try {
            userTask.setStatus(DatabaseValue.FINISH);
            userTask.setTask(task);
            userTask.setUser(userSubject.getUser());
            courseSubjectTask.setUserTask(userTask);
            courseSubjectTask.setUserSubject(userSubject);
            listCourseSubjectTask.add(courseSubjectTask);
            userTask.setListCourseSubjectTask(listCourseSubjectTask);
            userTaskDAO.save(userTask);
        }
        catch (Exception e) {
            log.error(e);
        }
    }
}
