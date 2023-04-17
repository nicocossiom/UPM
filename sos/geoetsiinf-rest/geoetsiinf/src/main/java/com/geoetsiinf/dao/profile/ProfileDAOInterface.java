package com.geoetsiinf.dao.profile;

import java.util.List;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOInterface;
import com.geoetsiinf.models.Profile;

public interface ProfileDAOInterface extends DAOInterface<Profile, String> {

    @Override
    public void delete(String keyA, String keyB) throws DAOException;

    @Override
    public Profile get(String key) throws DAOException;

    @Override
    public List<Profile> getAll(String keyA, String keyB) throws DAOException;

    @Override
    public void insert(String keyA, String keyB) throws DAOException;

    @Override
    public void update(Profile element) throws DAOException;
    
}