package com.geoetsiinf.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.UriInfo;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.User;


public class UserDAO implements UserDAOInterface {

    private static final String INSERT = "INSERT INTO users(first_name, last_name, user_name, email, postal_code) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE users SET "; 
    private static final String DELETE = "DELETE from users WHERE user_name = ?";
    private static final String GETALL = "SELECT * FROM users";
    private static final String GETONE = "SELECT * from users WHERE user_name = ?";

    public Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * @param user
     * @throws DAOException
     */
    @Override
    public void insert(User user) throws DAOException {
        checkIfCorrectValues(user);
        try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
            if (user.getUserName().contains("/")) {
                throw new DAOException("Ilegal name character " + '/');
            }
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getPostalCode());
            if (ps.executeUpdate() == 0) {
                throw new DAOException("User" + user + " could not be inserted");
            }
        } catch (SQLException e) {
            throw new DAOException("Ya existe este usuario");
        } catch (NullPointerException e) {
            throw new DAOException("There are required fields missing for the operation");
        }
    }

    private void checkIfCorrectValues(User user) throws DAOException {
        if (user.getUserName().contains(" /")) {
            throw new DAOException("User name connot contain /");
        }
    }

    /**
     * @param userName
     * @param fieldMap
     * @throws DAOException
     */
    @Override
    public void modify(Map<String, Object> fieldMap) throws DAOException {
        String userName = (String) fieldMap.get("user_name");
        StringBuilder sql = new StringBuilder(UPDATE);
        for (Entry<String, Object> entry : fieldMap.entrySet()) {
            sql.append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                sql.append("'" + value + "'" );
            } else {
                sql.append(value);
            }
            sql.append(", ");
        }
        sql.deleteCharAt(sql.length() - 2);

        sql.append("WHERE user_name = '" + userName + "'");
        try (Statement st = conn.createStatement()) {
            if (st.executeUpdate(sql.toString()) == 0) {
                throw new DAOException("User" + userName + " could not be modified");
            }
        } catch (SQLException e) {
            throw new DAOException("User" + userName +
                    " could not be modified" + "reson: SQLException: " + e.getMessage());
        }
    }

    /**
     * @param userName
     * @throws DAOException
     */
    @Override
    public void delete(String userName) throws DAOException {
        // logger.trace("Deleting user {} into database ", userName);
        try (PreparedStatement st = conn.prepareStatement(DELETE)) {
            st.setString(1, userName);
            if (st.executeUpdate() == 0) {
                throw new DAOException("User" + userName + "could not be deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("User" + userName + "could not be deleted");
        }
    }

    
    /** 
     * @param rs
     * @return List<User>
     * @throws DAOException
     */
    private List<User> resultSetMapper(ResultSet rs) throws DAOException {
        List<User> userList = new ArrayList<>();
        // empty user whose fields we will fill as demanded by query
        try {
            while (rs.next()) {
                User user = new User();
                userList.add(user);
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPostalCode(rs.getInt("postal_code"));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return userList;
    }

    /**
     * @return List<User>
     * @throws DAOException
     */
    @Override
    public List<User> getAll() throws DAOException {
        // logger.trace("Getting all users...");
        List<User> userList = null;
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(GETALL);
            userList = resultSetMapper(rs);
        } catch (SQLException e) {
            // DAOManager.logSQLError(e, logger);
            throw new DAOException("Could not retrieve users");
        }
        return userList;
    }

    /**
     * @param selectColumns Columns to select
     * @param fieldMap
     *                      - Key: Column to use as query parameter
     *                      - Value: Object to assign to the parameter
     * @return List<User>
     * @throws DAOException
     */
    @Override
    public List<User> getWithFilter(String parameter) throws DAOException {
        List<User> userList = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE first_name LIKE \"%");
        sql.append(parameter).append("%\"");
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql.toString());
            userList = resultSetMapper(rs);

        } catch (SQLException e) {
            // DAOManager.logSQLError(e, logger);
            throw new DAOException(e.getMessage());
        }
        return userList;
    }

    
    /** 
     * @param userId
     * @throws DAOException
     */
    public void doesUserExist(String userId) throws DAOException {
        boolean result = false;
        try (PreparedStatement ps = conn.prepareStatement(GETONE)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if (!rs.next())
                throw new DAOException("User" + userId + "does not exist");
        } catch (SQLException e) {
            throw new DAOException("Error in query");
        }
    }

    
    /** 
     * @param userID
     * @return User
     * @throws DAOException
     */
    @Override
    public User getOne(String userID) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = conn.prepareStatement(GETONE);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = createUser(rs);
            }
            else {
                throw new DAOException("Failed to retrieve the user");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL error", e);
        }
        return user;
    }

    private User createUser(ResultSet rs) throws SQLException {
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String userName = rs.getString("user_name");
        String email = rs.getString("email");
        int postalCode = rs.getInt("postal_code");
        User user = new User(firstName, lastName, userName, email, postalCode);
        return user;
    }  
    
    /** 
     * @param preparedParams
     * @return List<User>
     * @throws DAOException
     */
    public List<User> getWithFilters(Map<String, Object> preparedParams) throws DAOException {
        List<User> queryResults = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * from users WHERE user_name="
                + preparedParams.get("user_name"));
        preparedParams.forEach((k, v) -> sql.append(k + v));
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql.toString());
            queryResults = resultSetMapper(rs);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return queryResults;

    }


}