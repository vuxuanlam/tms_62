package tms62.business;

import java.util.List;

import tms62.model.entity.Courses;
import tms62.model.entity.CoursesSubjects;
import tms62.model.entity.Subjects;
import tms62.model.entity.Users;
import tms62.model.entity.UsersCourses;
import tms62.model.entity.UsersSubjects;

public interface CourseBusiness {

    public List<Courses> getAllCourses();
    
    public Courses getCourseById(Courses course);
    
    public List<Courses> getListCourseByAccount(Users user) throws Exception;
    
    public List<Subjects> getSubjectNotOfCourse(Courses course);
    
    public void removeSubject(CoursesSubjects courseSubject);
    
    public CoursesSubjects getCourseSubjectById(CoursesSubjects courseSubject);
    
    public Subjects getSubjectById(Subjects subject);
    
    public void addSubject(Courses course, Subjects subject);
    
    public List<Users> getListUserNotOfCourse(Courses course);
    
    public Users getUserById(Users user);
    
    public void addUserToCourse(Users user, Courses course);
    
    public void removeUserFromCourse(Users user, Courses course);
    
    public void startCourse(Courses course);
    
    public void finishCourse(Courses course);
    
    public Courses createCourse(Courses course, Subjects subject);
    
    public List<UsersCourses> getUsersCoursesFromCourseId(Courses course)
            throws Exception;
    
    public List<Subjects> getSubjects();

    public List<UsersSubjects> getListUserSubject(Users user, Courses course);
    
    public void removeCourse(Courses course);
    
    public void updateCourse(Courses course);
    
    public void saveActivity(Users user, int targetId, String log);
    
    public void saveActivity(Users user, String target, int targetId, String log);

}
