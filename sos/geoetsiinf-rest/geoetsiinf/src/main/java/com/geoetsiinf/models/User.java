package com.geoetsiinf.models;

import java.util.HashMap;
import java.util.Map;
import com.geoetsiinf.dao.DAOEnums;
import com.geoetsiinf.dao.DAOEnums.URIs;

public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private int postalCode;

    private String friends;
    private String href;
    private String foundTreasures;
    private String treasures;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private String profile;

    public User(String firstName, String lastName, String userName, String email, int postalCode) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.postalCode = postalCode;
        this.friends = URIs.FRIENDS.toString(userName);
        this.href = URIs.USER.toString(userName);
        this.foundTreasures = URIs.FOUNDTREASURES.toString(userName);
        this.treasures = URIs.ADDEDTREASURES.toString(userName);
        this.profile = URIs.PROFILE.toString(userName);
    }

    public User() {
        
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.friends = URIs.FRIENDS.toString(userName);
        this.href = URIs.USER.toString(userName);
        this.foundTreasures = URIs.FOUNDTREASURES.toString(userName);
        this.treasures = URIs.ADDEDTREASURES.toString(userName);
        this.profile = URIs.PROFILE.toString(userName);
        this.userName = userName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the postalCode
     */
    public Integer getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the friends
     */
    public String getFriends() {
        return friends;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @return the foundTreasures
     */
    public String getFoundTreasures() {
        return foundTreasures;
    }

    /**
     * @return the treasures
     */
    public String getTreasures() {
        return treasures;
    }

    /**
     * @return Map<String, Object>
     * @throws UserModelException
     */
    public Map<String, Object> toMap() throws UserModelException {
        Map<String, Object> changesMap = new HashMap<>();

        Object a = this.getFirstName();
        Object b = this.getLastName();
        Object c = this.getEmail();
        Object d = this.getPostalCode();
        if (a != null)
            changesMap.put("first_name", a);
        if (b != null)
            changesMap.put("last_name", b);
        if (c != null)
            changesMap.put("email", c);
        if (d != null)
            changesMap.put("postal_code", d);
        return changesMap;
    }

}