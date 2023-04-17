package com.geoetsiinf.dao.manager;

import com.geoetsiinf.dao.foundTreasure.FoundTreasureDAO;
import com.geoetsiinf.dao.friend.FriendDAO;
import com.geoetsiinf.dao.profile.ProfileDAO;
import com.geoetsiinf.dao.treasure.TreasureDAO;
import com.geoetsiinf.dao.user.UserDAO;

public interface DAOManagerInterface {
    
    UserDAO getUserDAO();

    FriendDAO getFriendDAO();

    TreasureDAO getTreasureDAO();

    FoundTreasureDAO getFoundTreasureDAO();

    ProfileDAO getProfileDAO();
        
}
