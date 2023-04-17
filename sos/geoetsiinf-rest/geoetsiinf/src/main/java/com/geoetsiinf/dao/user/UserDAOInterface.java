package com.geoetsiinf.dao.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.User;

public interface UserDAOInterface {
    void insert(User t) throws DAOException;

    void modify(Map<String, Object> fieldMap) throws DAOException;

    void delete(String id) throws DAOException;

    List<User> getAll() throws DAOException;

    List<User> getWithFilter(String query) throws DAOException;

    User getOne(String query) throws DAOException;

}
