package tms62.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, Id extends Serializable> {
    
    public void save(E transientInstance) throws Exception;
    
    public void delete(E persistentInstance) throws Exception;
    
    public void update(E transientInstance) throws Exception;
    
    public E findById(Id id) throws Exception;
    
    public E findById(Id id, boolean lock) throws Exception;
    
    public List<E> findByExample(E instance) throws Exception;
    
    public List<E> findByProperty(String propertyName, Object value)
            throws Exception;
    
    public List<E> listAll() throws Exception;
}
