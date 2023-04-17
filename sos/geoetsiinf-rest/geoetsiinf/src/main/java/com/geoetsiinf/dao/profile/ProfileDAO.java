package com.geoetsiinf.dao.profile;

import java.sql.Connection;
import java.util.List;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.models.Profile;
import com.geoetsiinf.models.Treasure;
import com.geoetsiinf.models.User;
import com.geoetsiinf.dao.user.UserDAO;
import com.geoetsiinf.dao.foundTreasure.FoundTreasureDAO;
import com.geoetsiinf.dao.friend.FriendDAO;
import com.geoetsiinf.dao.treasure.TreasureDAO;

public class ProfileDAO implements ProfileDAOInterface{

    private Connection conn;
    private DAOManager manager = new DAOManager();
    private UserDAO userDAO = manager.getUserDAO();
    private FoundTreasureDAO foundTreasureDAO = manager.getFoundTreasureDAO();
    private FriendDAO friendDAO = manager.getFriendDAO();
    private TreasureDAO treasureDAO = manager.getTreasureDAO();

    public ProfileDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void delete(String keyA, String keyB) throws DAOException {
        // NOT APPLICABLE        
    }

    @Override
    public Profile get(String userName) throws DAOException {
        User user = userDAO.getOne(userName);
        List<Treasure> found = foundTreasureDAO.getAll(userName, null);
        int numFoundTreasures = found.size();
        List<Treasure> lastFoundTreasures = null;
        if(numFoundTreasures <= 5) {
            lastFoundTreasures = found;
        }
        else {
            lastFoundTreasures = found.subList(0, 4);
        }
        List<User> friends = friendDAO.getAll(userName, null);
        int numFriends = friends.size();
        List<Treasure> addedTreasures = treasureDAO.getAll(userName);
        int numAddedTreasures = addedTreasures.size();
        Profile userProfile = new Profile(user, numFoundTreasures, lastFoundTreasures,
        numFriends, numAddedTreasures);
        return userProfile;
    }

    @Override
    public List<Profile> getAll(String keyA, String keyB) throws DAOException {
        // NOT APPLICABLE        
        return null;
    }

    @Override
    public void insert(String keyA, String keyB) throws DAOException {
        // NOT APPLICABLE        
    }

    @Override
    public void update(Profile element) throws DAOException {
        // NOT APPLICABLE        
    }
    
}
