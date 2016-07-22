package tms62.business.impl;

import tms62.business.TaskBusiness;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;

public class TaskBusinessImpl implements TaskBusiness {

  private TaskDAO    taskDAO;
  private SubjectDAO subjectDAO;

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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Tasks getTaskById(Tasks task) {

    try {
      return taskDAO.findById(task.getTaskId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void createTask(Tasks task) {

    try {
      taskDAO.save(task);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Subjects getSubjectById(Subjects subject) {

    try {
      return subjectDAO.findById(subject.getSubjectId());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}
