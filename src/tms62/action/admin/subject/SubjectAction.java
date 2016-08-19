package tms62.action.admin.subject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.SubjectBusiness;
import tms62.dao.impl.CourseDAOImpl;
import tms62.messages.Messages;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private SubjectBusiness   subjectBusiness;
    private Subjects          subject;
    private List<Subjects>    listSubjects;
    private List<String>      taskName;
    private List<String>      taskDescription;
    private boolean           update           = false;
    private CoursesSubjects   courseSubject;
    private String            log;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    
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
    
    public List<Subjects> getListSubjects() {

        return listSubjects;
    }
    
    public void setListSubjects(List<Subjects> listSubjects) {

        this.listSubjects = listSubjects;
    }
    
    public boolean isUpdate() {

        return update;
    }
    
    public void setUpdate(boolean update) {

        this.update = update;
    }
    
    public CoursesSubjects getCourseSubject() {

        return courseSubject;
    }
    
    public void setCourseSubject(CoursesSubjects courseSubject) {

        this.courseSubject = courseSubject;
    }
    
    public String createSubject() {

        List<Tasks> listTask;
        if (Helpers.isExist(subject)) {
            // list task of subject
            listTask = validateTask(subject);
            if (Helpers.isEmpty(subject.getListTasks())) {
                subject.setListTasks(listTask);
            }
            else {
                subject.getListTasks().addAll(listTask);
            }
            // create subject
            subjectBusiness.createSubject(subject);
            // Log create subject
            log = "Create Subject ".concat(subject.getName());
            subjectBusiness.saveActivity(accountDetails.getUser(),
                    subject.getSubjectId(), log);
            addActionMessage(Messages.ADD_SUCCESS);
        }
        return SUCCESS;
    }
    
    public String viewAllSubject() {

        listSubjects = subjectBusiness.getSubjects();
        return SUCCESS;
    }
    
    public String deleteSubject() {

        if (Helpers.isExist(subject)
                && Helpers.isExist(subjectBusiness.getSubjectById(subject))) {
            // remove subject
            subject = subjectBusiness.getSubjectById(subject);
            subjectBusiness.removeSubject(subject);
            // Log delete subject
            log = "Delete subject ".concat(subject.getName());
            subjectBusiness.saveActivity(accountDetails.getUser(),
                    subject.getSubjectId(), log);
            addActionMessage(Messages.DELETE_SUCCESS);
        }
        else {
            addActionError(Messages.DELETE_ERROR);
        }
        return SUCCESS;
    }
    
    public String updateSubject() {

        if (Helpers.isExist(subject)) {
            if (update) {
                // update
                subjectBusiness.updateSubject(subject);
                // Log update
                log = "Update Subject ".concat(subject.getName());
                subjectBusiness.saveActivity(accountDetails.getUser(),
                        subject.getSubjectId(), log);
            }
            subject = subjectBusiness.getSubjectById(subject);
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    public String viewSubjectDetails() {

        if (Helpers.isExist(subject)) {
            subject = subjectBusiness.getSubjectById(subject);
            return SUCCESS;
        }
        return ERROR;
    }
    
    // return list task of subject.
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
    
    public String startSubject() {

        if (Helpers.isExist(courseSubject)) {
            courseSubject = subjectBusiness
                    .getCourseSubjecttById(courseSubject);
            // start
            subjectBusiness.startSubject(courseSubject);
            // Log start subject
            log = "Start Subject".concat(courseSubject.getSubject().getName()
                    .concat("Of Course")
                    .concat(courseSubject.getCourse().getName()));
            subjectBusiness.saveActivity(accountDetails.getUser(),
                    CourseDAOImpl.NAME,
                    courseSubject.getCourse().getCourseId(), log);
            return SUCCESS;
        }
        else
            return ERROR;
    }
    
    public String finishSubject() {

        if (Helpers.isExist(courseSubject)) {
            // finish subject
            courseSubject = subjectBusiness
                    .getCourseSubjecttById(courseSubject);
            subjectBusiness.finishSubject(courseSubject);
            // Log finish subject
            log = "Finish Subject ".concat(courseSubject.getSubject().getName()
                    .concat(" Of Course ")
                    .concat(courseSubject.getCourse().getName()));
            subjectBusiness.saveActivity(accountDetails.getUser(),
                    CourseDAOImpl.NAME,
                    courseSubject.getCourse().getCourseId(), log);
            return SUCCESS;
        }
        else
            return ERROR;
    }
}
