package tms62.business.impl;

import tms62.business.SubjectBusiness;
import tms62.dao.SubjectDAO;
import tms62.dao.TaskDAO;
import tms62.model.entity.Subjects;
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
  public void createSubject(Subjects subject) {

    Subjects tempSubject;

    try {
      tempSubject = subjectDAO.findSubjectByName(subject);
      if (Helpers.isNull(tempSubject)) {
        subjectDAO.save(subject);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
