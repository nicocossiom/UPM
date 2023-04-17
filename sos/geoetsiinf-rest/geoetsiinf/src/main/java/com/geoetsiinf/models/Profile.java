package com.geoetsiinf.models;

import java.util.List;

public class Profile {

    private User user;
    private int numFoundTreasures;
    private List<Treasure> lastFoundTreasures;
    private int numFriends;
    private int numAddedTreasures;
    
    public Profile() {
    }

    public Profile(User user, int numFoundTreasures, List<Treasure> lastFoundTreasures, int numFriends,
            int numAddedTreasures) {
        this.user = user;
        this.numFoundTreasures = numFoundTreasures;
        this.lastFoundTreasures = lastFoundTreasures;
        this.numFriends = numFriends;
        this.numAddedTreasures = numAddedTreasures;
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getNumFoundTreasures() {
        return numFoundTreasures;
    }
    public void setNumFoundTreasures(int numFoundTreasures) {
        this.numFoundTreasures = numFoundTreasures;
    }
    public List<Treasure> getLastFoundTreasures() {
        return lastFoundTreasures;
    }
    public void setLastFoundTreasures(List<Treasure> lastFoundTreasures) {
        this.lastFoundTreasures = lastFoundTreasures;
    }
    public int getNumFriends() {
        return numFriends;
    }
    public void setNumFriends(int numFriends) {
        this.numFriends = numFriends;
    }
    public int getNumAddedTreasures() {
        return numAddedTreasures;
    }
    public void setNumAddedTreasures(int numAddedTreasures) {
        this.numAddedTreasures = numAddedTreasures;
    }
    
}
