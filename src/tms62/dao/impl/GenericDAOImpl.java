package tms62.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import tms62.dao.GenericDAO;

public class GenericDAOImpl<E, Id extends Serializable> extends
    HibernateDaoSupport implements GenericDAO<E, Id> {

  private Class<E> persistentClass;

  public GenericDAOImpl(Class<E> persistentClass) {

    this.persistentClass = persistentClass;
  }

  public Class<E> getPersistentClass() {

    return persistentClass;
  }

  protected void initDao() {

    // do nothing
  }

  public void save(E transientInstance) throws Exception {

    try {
      getHibernateTemplate().save(transientInstance);
    } catch (RuntimeException re) {
      throw re;
    }
  }

  @Override
  public void update(E transientInstance) throws Exception {

    try {
      getHibernateTemplate().update(transientInstance);
    } catch (RuntimeException re) {
      throw re;
    }

  }

  public void delete(E persistentInstance) throws Exception {

    try {
      getHibernateTemplate().delete(persistentInstance);
    } catch (RuntimeException re) {
      throw re;
    }
  }

  public E findById(Id id) throws Exception {

    return findById(id, false);
  }

  public E findById(Id id, boolean lock) {

    try {
      E entity;
      if (lock) {
        getSession().setCacheMode(CacheMode.PUT);
        entity = (E) getSession().get(getPersistentClass(), id,
            LockMode.UPGRADE);
      } else {
        entity = (E) getSession().get(getPersistentClass(), id);
      }
      if (entity != null)
        getSession().refresh(entity);
      if (entity == null) {
        getSession().load(getPersistentClass(), id);
      }
      if (entity != null)
        getSession().refresh(entity);
      return entity;
    } catch (RuntimeException re) {
      throw re;
    }
  }

  public List<E> findByExample(E instance) throws Exception {

    try {
      List results = getHibernateTemplate().findByExample(instance);
      return results;
    } catch (RuntimeException re) {
      throw re;
    }
  }

  public List<E> findByProperty(String propertyName, Object value)
      throws Exception {

    try {
      String queryString = "from " + persistentClass.getName()
          + " model where model." + propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re) {
      throw re;
    }
  }

  public List<E> listAll() throws Exception {

    try {
      return getHibernateTemplate().loadAll(getPersistentClass());
    } catch (RuntimeException re) {
      throw re;
    }
  }

}
