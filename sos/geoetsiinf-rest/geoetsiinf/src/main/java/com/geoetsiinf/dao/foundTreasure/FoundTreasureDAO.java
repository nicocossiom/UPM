package com.geoetsiinf.dao.foundTreasure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.geoetsiinf.dao.treasure.TreasureDAO;
import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.Treasure;

public class FoundTreasureDAO implements FoundTreasureDAOInterface {

    final static String INSERT = "INSERT INTO found_treasures VALUES(?, ?)";
    final static String GETALL = "SELECT * FROM treasures t " +
    "INNER JOIN found_treasures f ON t.treasure_id = f.treasure_id " +
    "WHERE f.user_name = ? ORDER BY date_added DESC";
    final static String GETFILTER = "SELECT * FROM treasures t " +
    "INNER JOIN found_treasures f ON t.treasure_id = f.treasure_id " +
    "WHERE f.user_name = ? AND date_added < ? ORDER BY date_added DESC";

    private Connection conn;

    public FoundTreasureDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void delete(String keyA, String keyB) throws DAOException {
        // NOT APPLICABLE
    }

    @Override
    public Treasure get(String key) throws DAOException {
        // NOT APPLICABLE
        return null;
    }

    @Override
    public List<Treasure> getAll(String userName, String beforeDate) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Treasure> treasures = null;
        try {
            if (beforeDate == null) {
                ps = conn.prepareStatement(GETALL);
            } else {
                ps = conn.prepareStatement(GETFILTER);
                String filter = beforeDate + " 00:00:00";
                ps.setString(2, filter);
            }
            ps.setString(1, userName);
            rs = ps.executeQuery();
            treasures = new ArrayList<>();
            treasures = TreasureDAO.resultSetMapperTreasure(rs);
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
        return treasures;
    }

    @Override
    public void insert(String userName, String treasureID) throws DAOException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, userName);
            ps.setString(2, treasureID);
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
    public void update(Treasure element) throws DAOException {
        // NOT APPLICABLE
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
