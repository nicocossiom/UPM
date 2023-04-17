package com.tapastop.app.model;

/**
 * The type Dish.
 */
/*
 Fichero de clase "Plato"
*/
public class Dish {
    private int id;
    private String bar;
    private String imagePath;
    private String type;
    private String name;
    private String origin;
    private String taste;
    private int userRating = 0;
    private double rating = 0.0;
    private int numRates = 0;

    /**
     * Instantiates a new Dish.
     */
    public Dish() {
    }

    /**
     * Instantiates a new Dish.
     *
     * @param name      the name
     * @param bar       the bar
     * @param origin    the origin
     * @param taste     the taste
     * @param imagePath the image path
     * @param type      the type
     */
    public Dish(String name, String bar, String origin, String taste, String imagePath, String type) {
        this.bar = bar;
        this.imagePath = imagePath;
        this.type = type;
        this.name = name;
        this.origin = origin;
        this.taste = taste;
    }

    /**
     * Gets user rating.
     *
     * @return the user rating
     */
    public int getUserRating() {
        return userRating;
    }

    /**
     * Sets user rating.
     *
     * @param userRating the user rating
     */
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets num rates.
     *
     * @return the num rates
     */
    public int getNumRates() {
        return numRates;
    }

    /**
     * Sets num rates.
     *
     * @param numRates the num rates
     */
    public void setNumRates(int numRates) {
        this.numRates = numRates;
    }

    /**
     * Gets bar.
     *
     * @return the bar
     */
    public String getBar() {
        return bar;
    }

    /**
     * Sets bar.
     *
     * @param bar the bar
     */
    public void setBar(String bar) {
        this.bar = bar;
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

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets origin.
     *
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets taste.
     *
     * @return the taste
     */
    public String getTaste() {
        return taste;
    }

    /**
     * Sets taste.
     *
     * @param taste the taste
     */
    public void setTaste(String taste) {
        this.taste = taste;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Rate dish.
     *
     * @param rating the rating
     */
    public void rateDish(double rating) {
        if (rating <= 5.0 && rating >= 1.0) {
            double points = this.rating * numRates;
            points += rating;
            numRates++;
            this.rating = points / numRates;
        }
    }

}
