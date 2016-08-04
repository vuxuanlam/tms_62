package tms62.business;

import java.util.List;

import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;

public interface SubjectBusiness {

  public void createSubject(Subjects subject);


  public List<Subjects> getSubjects();

  public void removeSubject(Subjects subject);

  public Subjects getSubjectById(Subjects subject);

  public void updateSubject(Subjects subject);

  


}
