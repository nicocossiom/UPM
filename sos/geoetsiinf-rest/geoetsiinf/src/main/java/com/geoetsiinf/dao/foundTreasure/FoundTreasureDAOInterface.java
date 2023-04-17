package com.geoetsiinf.dao.foundTreasure;

import java.util.List;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOInterface;
import com.geoetsiinf.models.Treasure;

public interface FoundTreasureDAOInterface extends DAOInterface<Treasure, String> {

    @Override
    public void delete(String keyA, String keyB) throws DAOException;

    @Override
    public Treasure get(String key) throws DAOException;

    @Override
    public List<Treasure> getAll(String userName, String beforeDate) throws DAOException;

    @Override
    public void insert(String userName, String treasureID) throws DAOException;

    @Override
    public void update(Treasure element) throws DAOException;
    
}
