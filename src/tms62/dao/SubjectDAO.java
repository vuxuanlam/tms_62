package tms62.dao;

import tms62.model.entity.Subjects;

public interface SubjectDAO extends GenericDAO<Subjects, Integer> {
    
    public Subjects findSubjectByName(Subjects subject) throws Exception;
}
