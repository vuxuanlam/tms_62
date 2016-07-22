package tms62.dao;

import tms62.model.entity.Users;

public interface UserDAO extends GenericDAO<Users, Integer> {
    
    public Users findUserByEmailPassword(Users user) throws Exception;
}
