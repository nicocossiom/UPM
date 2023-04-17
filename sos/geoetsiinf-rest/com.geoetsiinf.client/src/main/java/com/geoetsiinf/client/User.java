package com.geoetsiinf.client;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Integer postalCode;
    public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public String getTreasures() {
		return treasures;
	}

	public void setTreasures(String treasures) {
		this.treasures = treasures;
	}

	public String getFoundTreasures() {
		return foundTreasures;
	}

	public void setFoundTreasures(String foundTreasures) {
		this.foundTreasures = foundTreasures;
	}

	private String href;
    private String friends;
    private String treasures;
    private String foundTreasures;
    private String profile;

    public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public User(String userName, String firstName, String lastName, String email, String postalCode) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.postalCode = Integer.parseInt(postalCode);
    }

    public User() {
        // empty constructor
    }

    // @XmlAttribute(required=false)

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
     * @return Map<String, Object>
     * @throws UserModelException
     */
    public Map<String, Object> toMap() {
        Map<String, Object> changesMap = new HashMap<String, Object>();

        Object a = this.getFirstName();
        Object b = this.getLastName();
        Object c = this.getUserName();
        Object d = this.getEmail();
        Object e = this.getPostalCode();
        if (a != null)
            changesMap.put("first_name", c);
        if (b != null)
            changesMap.put("last_name", b);
        if (d != null)
            changesMap.put("email", d);
        if (e != null)
            changesMap.put("postal_code", e);
        return changesMap;
    }
    
    public String toString() {
    	return String.format("User: %s, Name: %s %s, E-mail: %s, Postcode: %d", userName, firstName, lastName, email, postalCode);
    }
}