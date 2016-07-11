package tms62.business;

import java.util.List;

import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;

public interface SubjectBusiness {

  public Subjects createSubject(Subjects subject);

  public void createTask(List<Tasks> task, Subjects subject);

}
