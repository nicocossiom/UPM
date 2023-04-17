package com.tapastop.app.collections;

import com.tapastop.app.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User collection.
 */
public class UserCollection {
    private static Map<String, User> userMap;

    /**
     * Construye una coleccion de usuarios insertando datos predefinidos de prueba..
     */
    public static void initialize() {
        User pancra = new User("pancracio", "123456", "pancra@grupo16.com", "Pancracio", "González García", "");
        User juan = new User("juanillo", "123456", "juan@grupo16.com", "Juan", "Vázquez Pérez", "");
        UserCollection.userMap = new HashMap<>();
        userMap.put(pancra.getId(), pancra);
        userMap.put(juan.getId(), juan);
    }

    /**
     * Autentica un usuario con un nombre de usuario y contraseña dados.
     *
     * @param name the name
     * @param pass the pass
     * @return the user
     */

    public static User authUser(String name, String pass) {
        User queried = userMap.get(name);
        if (queried == null || !queried.getPassword().equals(pass)) {
            return null;
        } else {
            return queried;
        }
    }

    public static User getUser(String id) {
        return userMap.get(id);
    }

    public static void modifyUser(String old, User newusr) {
        if (userMap.containsKey(old)) {
            userMap.remove(old);
            userMap.put(newusr.getId(), newusr);
        }
    }

    /**
     * Checks if user exists
     *
     * @param name the name
     * @return the boolean
     */
    public static boolean userExists(String name) {
        return userMap.containsKey(name);
    }

    /**
     * Adds a given user
     *
     * @param toAdd the to add
     * @return the boolean
     */
    public static boolean addUser(User toAdd) {
        if (userMap.containsKey(toAdd.getId())) {
            return false;
        } else {
            userMap.put(toAdd.getId(), toAdd);
            return true;
        }
    }
}
