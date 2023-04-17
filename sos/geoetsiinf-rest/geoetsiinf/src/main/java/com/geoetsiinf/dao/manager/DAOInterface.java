package com.geoetsiinf.dao.manager;

import java.util.List;

import com.geoetsiinf.dao.DAOException;

public interface DAOInterface<T, K> {

    public void insert(K keyA, K keyB) throws DAOException;

    public void update(T element) throws DAOException;

    public void delete(K keyA, K keyB) throws DAOException;

    public T get(K key) throws DAOException;

    public List<T> getAll(K keyA, K keyB) throws DAOException;

}
