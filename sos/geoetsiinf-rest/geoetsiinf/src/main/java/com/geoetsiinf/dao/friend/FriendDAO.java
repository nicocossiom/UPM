package com.geoetsiinf.dao.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.User;

public class FriendDAO implements FriendDAOInterface {

    final static String INSERT = "INSERT INTO friends(user_name_1, user_name_2) VALUES (?, ?)";
    final static String DELETE = "DELETE FROM friends WHERE user_name_1 = ? AND user_name_2 = ?";
    final static String GETALL = "SELECT * FROM users u" +
            " INNER JOIN friends f ON u.user_name = f.user_name_2 WHERE f.user_name_1 = ?";
    final static String GETFILTER = "SELECT * FROM users u " +
            "INNER JOIN friends f ON u.user_name = f.user_name_2 " +
            "WHERE f.user_name_1 = ? AND u.first_name LIKE ?";

    private Connection conn;

    public FriendDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(String userName, String friendUserName) throws DAOException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, userName);
            ps.setString(2, friendUserName);
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Failed to insert a friend");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL error", e);
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void update(User friend) {
        // NOT APPICABLE
    }

    @Override
    public void delete(String userName, String userNameFriend) throws DAOException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setString(1, userName);
            ps.setString(2, userNameFriend);
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Failed to deleted a friend");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL error", e);
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public User get(String element) {
        // NOT APPICABLE
        return null;
    }

    @Override
    public List<User> getAll(String userName, String friendFirstName) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> friends = null;
        try {
            if (friendFirstName == null) {
                ps = conn.prepareStatement(GETALL);
            } else {
                ps = conn.prepareStatement(GETFILTER);
                String filter = "%" + friendFirstName + "%";
                ps.setString(2, filter);
            }
            ps.setString(1, userName);
            rs = ps.executeQuery();
            friends = new ArrayList<>();
            while (rs.next()) {
                friends.add(createFriend(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL error", e);
        } finally {
            closePreparedStatement(ps);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL error", e);
                }
            }
        }
        return friends;
    }

    private User createFriend(ResultSet rs) throws SQLException {
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String userName = rs.getString("user_name");
        String email = rs.getString("email");
        int postalCode = rs.getInt("postal_code");
        User friend = new User(firstName, lastName, userName, email, postalCode);
        return friend;
    }

    private void closePreparedStatement(PreparedStatement ps) throws DAOException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DAOException("SQL error", e);
            }
        }
    }

}
