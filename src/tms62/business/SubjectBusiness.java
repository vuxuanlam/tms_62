package tms62.business;

import java.util.List;

import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.Users;
import tms62.model.entity.UsersSubjects;

public interface SubjectBusiness {
    
    public void createSubject(Subjects subject);
    
    public List<Subjects> getSubjects();
    
    public void removeSubject(Subjects subject);
    
    public Subjects getSubjectById(Subjects subject);
    
    public void updateSubject(Subjects subject);
    
    public void startSubject(CoursesSubjects courseSubject);
    
    public void finishSubject(CoursesSubjects courseSubject);

    public CoursesSubjects getCourseSubjecttById(CoursesSubjects courseSubject);
    
    public UsersSubjects finishSubject(UsersSubjects userSubject);
    
    public void saveActivity(Users user, int targetId, String log);
}
