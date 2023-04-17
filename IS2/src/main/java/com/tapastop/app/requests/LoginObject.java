package com.tapastop.app.requests;

/**
 * The type Login object.
 */
public class LoginObject {
    private String user;
    private String pass;

    /**
     * Instantiates a new Login object.
     *
     * @param user the user
     * @param pass the pass
     */
    public LoginObject(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    /**
     * Instantiates a new Login object.
     */
    public LoginObject() {
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets pass.
     *
     * @param pass the pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
