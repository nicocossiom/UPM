package com.geoetsiinf.client;

public class Profile {

    private User user;
    private int numFoundTreasures;
    private Treasure[] lastFoundTreasures;
    private int numFriends;
    private int numAddedTreasures;
    
    public Profile() {
    }

    public Profile(User user, int numFoundTreasures, Treasure[] lastFoundTreasures, int numFriends,
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

    public int getNumFoundTreasures() {
        return numFoundTreasures;
    }
    public void setNumFoundTreasures(int numFoundTreasures) {
        this.numFoundTreasures = numFoundTreasures;
    }
    public Treasure[] getLastFoundTreasures() {
        return lastFoundTreasures;
    }
    public void setLastFoundTreasures(Treasure[] lastFoundTreasures) {
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
    public String toString() {
    	return "Profile_" + user;
    }
    
}
