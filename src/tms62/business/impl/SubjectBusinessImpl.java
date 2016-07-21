package tms62.business.impl;

import java.util.List;

import tms62.business.SubjectBusiness;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.util.Helpers;

public class SubjectBusinessImpl implements SubjectBusiness {

  private SubjectDAO subjectDAO;
  private TaskDAO    taskDAO;

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
  public Subjects createSubject(Subjects subject) {

    Subjects tempSubject;

    try {
      tempSubject = subjectDAO.findSubjectByName(subject);
      if (Helpers.isNull(tempSubject)) {
        subjectDAO.save(subject);
        return subject;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void createTask(List<Tasks> listTask, Subjects subject) {

    for (Tasks task : listTask) {

      try {
        task.setSubjectId(subject.getSubjectId());
        taskDAO.save(task);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
