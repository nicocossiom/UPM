package com.tapastop.app.model;

import com.tapastop.app.requests.RegisterObject;

/**
 * The type User.
 */
/*
Fichero de clase "Usuario"
 */
public class User {
    private String id;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String imagePath;
    private String address;

    /**
     * Instantiates a new User.
     *
     * @param id        the id
     * @param password  the password
     * @param email     the email
     * @param name      the name
     * @param surname   the surname
     * @param imagePath the image path
     */
    public User(String id, String password, String email, String name, String surname, String imagePath) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.imagePath = imagePath;
    }

    /**
     * Instantiates a new User.
     *
     * @param registerObject the register object
     */
    public User(RegisterObject registerObject) {
        this.id = registerObject.getId();
        this.password = registerObject.getPassword();
        this.email = registerObject.getEmail();
        this.name = registerObject.getName();
        this.surname = registerObject.getSurname();
        this.imagePath = registerObject.getImagePath();
    }

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets image path.
     *
     * @param imagePath the image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
