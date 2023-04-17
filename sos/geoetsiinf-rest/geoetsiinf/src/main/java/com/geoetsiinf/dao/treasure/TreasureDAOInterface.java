package com.geoetsiinf.dao.treasure;

import java.util.List;
import java.util.Map;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.Treasure;

public interface TreasureDAOInterface {
    int insert(Treasure t) throws DAOException;

    void modify(Map<String, Object> fieldMap, Integer treasureId) throws DAOException;

    void delete(String userName, String trasureId) throws DAOException;

    List<Treasure> getAll(String userName) throws DAOException;

    List<Treasure> get(Map<String, Object> preparedParams) throws DAOException;

    Treasure getOne(String userName, Integer trasureId) throws DAOException;

}
