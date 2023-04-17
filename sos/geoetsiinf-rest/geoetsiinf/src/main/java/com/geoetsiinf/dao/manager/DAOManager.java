package com.geoetsiinf.dao.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.geoetsiinf.dao.foundTreasure.FoundTreasureDAO;
import com.geoetsiinf.dao.friend.FriendDAO;
import com.geoetsiinf.dao.profile.ProfileDAO;
import com.geoetsiinf.dao.treasure.TreasureDAO;
import com.geoetsiinf.dao.user.UserDAO;

public class DAOManager implements DAOManagerInterface {

    static final String URL = "jdbc:mysql://localhost:3306/geoetsiinfdb";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    Connection conn;
    private UserDAO users = null;
    private FriendDAO friends = null;
    private TreasureDAO treasures = null;
    private FoundTreasureDAO foundTreasures = null;
    private ProfileDAO profiles = null;

    public DAOManager() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, "geoetsiinf", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FriendDAO getFriendDAO() {
        if (friends == null) {
            friends = new FriendDAO(conn);
        }
        return friends;
    }

    @Override
    public TreasureDAO getTreasureDAO() {
        if (treasures == null) {
            treasures = new TreasureDAO(conn);
        }
        return treasures;
    }

    @Override
    public UserDAO getUserDAO() {
        if (users == null) {
            users = new UserDAO(conn);
        }
        return users;
    }

    @Override
    public FoundTreasureDAO getFoundTreasureDAO() {
        if (foundTreasures == null) {
            foundTreasures = new FoundTreasureDAO(conn);
        }
        return foundTreasures;
    }

    @Override
    public ProfileDAO getProfileDAO() {
        if (profiles == null) {
            profiles = new ProfileDAO(conn);
        }
        return profiles;
    }

}
