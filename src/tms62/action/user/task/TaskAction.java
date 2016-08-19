package tms62.action.user.task;

import tms62.business.TaskBusiness;
import tms62.model.entity.Tasks;
import tms62.model.entity.UsersSubjects;
import tms62.util.Helpers;

import com.opensymphony.xwork2.ActionSupport;

public class TaskAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    private TaskBusiness      taskBusiness;
    private Tasks             task;
    private UsersSubjects     userSubject;
    
    public UsersSubjects getUserSubject() {
    
        return userSubject;
    }
    
    public void setUserSubject(UsersSubjects userrSubject) {
    
        this.userSubject = userrSubject;
    }

    public Tasks getTask() {
    
        return task;
    }
    
    public void setTask(Tasks task) {
    
        this.task = task;
    }

    public TaskBusiness getTaskBusiness() {
    
        return taskBusiness;
    }
    
    public void setTaskBusiness(TaskBusiness taskBusiness) {
    
        this.taskBusiness = taskBusiness;
    }
    
    public String finishTask() {
    
        if (Helpers.isExist(userSubject) && Helpers.isExist(task)) {
            task = taskBusiness.getTaskById(task);
            userSubject = taskBusiness.getUserSubjectById(userSubject);
            taskBusiness.finishTask(userSubject, task);
            return SUCCESS;
        }
        else
            return ERROR;
    }
}
