package com.geoetsiinf.dao.friend;

import java.util.List;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOInterface;
import com.geoetsiinf.models.User;

public interface FriendDAOInterface extends DAOInterface<User, String> {

    public void insert(String userName, String friendUserName) throws DAOException;

    public void update(User friend) throws DAOException;

    public void delete(String userName, String userNameFriend) throws DAOException;

    public User get(String friend) throws DAOException;

    public List<User> getAll(String userName, String filter) throws DAOException;

}
