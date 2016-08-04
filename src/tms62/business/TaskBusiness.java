package tms62.business;

import tms62.model.entity.Subjects;
import tms62.model.entity.Tasks;

public interface TaskBusiness {
    
    public void removeTask(Tasks task);
    
    public Tasks getTaskById(Tasks task);
    
    public void createTask(Tasks task);
    
    public Subjects getSubjectById(Subjects subject);
}
