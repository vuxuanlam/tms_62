package tms62.model.entity;

import java.io.Serializable;

public class UsersSubjects implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int               userSubjectId;
  private boolean           status;
  private Subjects          subject;
  private Users             user;

  public int getUserSubjectId() {

    return userSubjectId;
  }

  public void setUserSubjectId(int userSubjectId) {

    this.userSubjectId = userSubjectId;
  }

  public boolean isStatus() {

    return status;
  }

  public void setStatus(boolean status) {

    this.status = status;
  }

  public Subjects getSubject() {

    return subject;
  }

  public void setSubject(Subjects subject) {

    this.subject = subject;
  }

  public Users getUser() {

    return user;
  }

  public void setUser(Users user) {

    this.user = user;
  }
}
