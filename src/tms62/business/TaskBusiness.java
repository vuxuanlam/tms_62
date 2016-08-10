package tms62.business;

import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;
import tms62.model.entity.Users;

public interface TaskBusiness {
    
    public void removeTask(Tasks task);
    
    public Tasks getTaskById(Tasks task);
    
    public void createTask(Tasks task);
    
    public Subjects getSubjectById(Subjects subject);
    
    public void saveActivity(Users user, int targetId, String log);
    
    public void saveActivity(Users user, String target, int targetId, String log);
}
