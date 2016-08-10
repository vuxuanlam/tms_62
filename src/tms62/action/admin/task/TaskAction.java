package tms62.action.admin.task;

import org.springframework.security.core.context.SecurityContextHolder;

import tms62.business.TaskBusiness;
import tms62.dao.impl.TaskDAOImpl;
import tms62.messages.Messages;
import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.springsecurity.AccountDetails;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class TaskAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private Tasks             task;
    private Subjects          subject;
    private TaskBusiness      taskBusiness;
    private String            log;
    private AccountDetails    accountDetails   = (AccountDetails) SecurityContextHolder
                                                       .getContext()
                                                       .getAuthentication()
                                                       .getPrincipal();
    
    public Subjects getSubject() {
    
        return subject;
    }
    
    public void setSubject(Subjects subject) {
    
        this.subject = subject;
    }
    
    public TaskBusiness getTaskBusiness() {
    
        return taskBusiness;
    }
    
    public void setTaskBusiness(TaskBusiness taskBusiness) {
    
        this.taskBusiness = taskBusiness;
    }
    
    public Tasks getTask() {
    
        return task;
    }
    
    public void setTask(Tasks task) {
    
        this.task = task;
    }
    
    public String removeTask() {
    
        if (Helpers.isExist(task)) {
            task = taskBusiness.getTaskById(task);
            log = "Remove Task ".concat(task.getName());
            taskBusiness.saveActivity(accountDetails.getUser(), task
                    .getSubject().getSubjectId(), log);
            taskBusiness.removeTask(task);
            addActionMessage(Messages.DELETE_SUCCESS);
        }
        return SUCCESS;
    }
    
    public String createTask() {
    
        if (!task.getName().trim().equals("")
                && !task.getDescription().trim().equals("")) {
            if (Helpers.isExist(subject)) {
                subject = taskBusiness.getSubjectById(subject);
                task.setSubject(subject);
                taskBusiness.createTask(task);
                log = "Create Task ".concat(task.getName());
                taskBusiness.saveActivity(accountDetails.getUser(),
                        TaskDAOImpl.NAME, subject.getSubjectId(), log);
                addActionMessage(Messages.ADD_SUCCESS);
                return SUCCESS;
            }
        }
        addActionError(Messages.ADD_ERROR);
        return ERROR;
    }
}
