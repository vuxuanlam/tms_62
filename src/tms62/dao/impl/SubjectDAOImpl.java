package tms62.dao.impl;

import org.hibernate.Query;

import tms62.constant.value.DatabaseValue;
import tms62.dao.SubjectDAO;
import tms62.model.entity.Subjects;

public class SubjectDAOImpl extends GenericDAOImpl<Subjects, Integer> implements
    SubjectDAO {

  public SubjectDAOImpl() {

    super(Subjects.class);
  }

  protected void initDAO() {

    // Do nothing
  }

  public Subjects findSubjectByName(Subjects subject) throws Exception {

    try {
      Query query = getSession().getNamedQuery("FindSubjectByName");
      query.setParameter(DatabaseValue.SUBJECT_NAME, subject.getName());
      return (Subjects) query.uniqueResult();
    } catch (RuntimeException re) {
      throw re;
    }
  }
}
