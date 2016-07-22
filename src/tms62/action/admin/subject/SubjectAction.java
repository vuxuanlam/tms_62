package tms62.action.admin.subject;

import java.util.ArrayList;
import java.util.List;

import tms62.business.SubjectBusiness;
import tms62.constant.message.BusinessMessage;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private SubjectBusiness   subjectBusiness;
  private Subjects          subject;
  private List<String>      taskName;
  private List<String>      taskDescription;

  public SubjectBusiness getSubjectBusiness() {

    return subjectBusiness;
  }

  public void setSubjectBusiness(SubjectBusiness subjectBusiness) {

    this.subjectBusiness = subjectBusiness;
  }

  public Subjects getSubject() {

    return subject;
  }

  public void setSubject(Subjects subject) {

    this.subject = subject;
  }

  public List<String> getTaskName() {

    return taskName;
  }

  public void setTaskName(List<String> taskName) {

    this.taskName = taskName;
  }

  public List<String> getTaskDescription() {

    return taskDescription;
  }

  public void setTaskDescription(List<String> taskDescription) {

    this.taskDescription = taskDescription;
  }

  public String createSubject() {

    List<Tasks> listTask;
    if (Helpers.isExist(subject)) {
      listTask = validateTask(subject);
      if (Helpers.isEmpty(subject.getListTasks())) {
        subject.setListTasks(listTask);
      } else {
        subject.getListTasks().addAll(listTask);
      }
      subjectBusiness.createSubject(subject);
      addActionMessage(BusinessMessage.ADD_SUCCESS);
    }
    return SUCCESS;
  }

  public List<Tasks> validateTask(Subjects subject) {

    List<Tasks> listTask = new ArrayList<Tasks>();
    Tasks task;
    for (int i = 0; i < taskName.size(); i++) {
      task = new Tasks();
      if (!taskName.get(i).trim().equals("")
          && !taskDescription.get(i).trim().equals("")) {
        task.setName(taskName.get(i).trim());
        task.setDescription(taskDescription.get(i).trim());
        task.setSubject(subject);
        listTask.add(task);
      }
    }
    return listTask;
  }
}
