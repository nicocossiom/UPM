package com.tapastop.app.collections;

import com.tapastop.app.model.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Dish collection.
 */
public class DishCollection {
    private static Map<Integer, Dish> dishes;
    private static int idcounter = 1;

    /**
     * Initializes dishes for testing purposes
     */
    public static void initialize() {
        Dish bocadillo = new Dish("Bocadillo de jamón", "Bar Tolo", "España", "salado",
                null, "Tapa");
        bocadillo.setId(0);
        DishCollection.dishes = new HashMap<Integer, Dish>();
        dishes.put(0, bocadillo);
    }

    /**
     * All existing dishes
     *
     * @return the dishes
     */
    public static List<Dish> getDishes() {
        return new ArrayList<Dish>(dishes.values());
    }

    /**
     * Adds the given dish
     *
     * @param dish the dish
     */
    public static void addDish(Dish dish) {
        dish.setId(idcounter);
        dishes.put(idcounter, dish);
        idcounter++;
    }

    /**
     * Rates the given dish
     *
     * @param id     the id
     * @param rating the rating
     */
    public static void rateDish(int id, int rating) {
        Dish toRate = dishes.get(id);
        if (toRate != null) {
            toRate.rateDish(rating);
        }
    }

    /**
     * Gets the name for the given dish.
     *
     * @param id the id
     * @return the dish name
     */
    public static String getDishName(int id) {
        return dishes.get(id).getName();
    }

}
