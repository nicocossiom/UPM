package com.geoetsiinf.dao.treasure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.models.Treasure;

public class TreasureDAO implements TreasureDAOInterface {

    private static final String INSERT = "INSERT INTO " +
            "treasures( treasure_name, coordinate_x, coordinate_y, terrain_type, difficulty, size, hint, author_user_name)"
            + "VALUES(?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE treasures SET ";
    private static final String DELETE = "DELETE from treasures WHERE treasure_id = ? AND author_user_name = ?";
    private static final String GETALL = "SELECT * FROM treasures WHERE author_user_name = ?";
    private static final String GETONEWITHAUTHOR = "SELECT * from treasures WHERE treasure_id = ? AND author_user_name = ?";
    private static final String GETONE = "SELECT * from treasures WHERE treasure_id = ?";

    private Connection conn = null;

    public TreasureDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * @param preparedParams
     * @return List<Treasure>
     * @throws DAOException
     */
    @Override
    public List<Treasure> get(Map<String, Object> preparedParams) throws DAOException {
        List<Treasure> queryResults = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * from treasures WHERE ");
        preparedParams.forEach((k, v) -> sql.append(k + v + " AND "));
        sql.delete(sql.length() - 5, sql.length());
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql.toString());
            queryResults = resultSetMapperTreasure(rs);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return queryResults;
    }

    /**
     * @param rs
     * @param authorUserName
     * @return List<Treasure>
     * @throws DAOException
     */
    public static List<Treasure> resultSetMapperTreasure(ResultSet rs) throws DAOException {
        List<Treasure> treasureList = new ArrayList<>();
        // empty user whose fields we will fill as demanded by query
        try {
            while (rs.next()) {
                Treasure treasure = new Treasure();
                treasureList.add(treasure);
                // treasure.setAuthorUserName(authorUserName);
                treasure.setCoordinateX(rs.getFloat("coordinate_x"));
                treasure.setCoordinateY(rs.getFloat("coordinate_y"));
                treasure.setDifficulty(rs.getInt("difficulty"));
                treasure.setSize(rs.getFloat("size"));
                treasure.setHint(rs.getString("hint"));
                treasure.setTerrainType(rs.getString("terrain_type"));
                treasure.setTreasureName(rs.getString("treasure_name"));
                treasure.setAuthorUserName(rs.getString("author_user_name"));
                treasure.setDateAdded(rs.getString("date_added"));
                treasure.setTreasureId(rs.getInt("treasure_id"));
            }
        } catch (SQLException e) {
            throw new DAOException("Could not map query to treasure model");
        }
        return treasureList;
    }

    /**
     * @param t
     * @return int
     * @throws DAOException
     */
    @Override
    public int insert(Treasure t) throws DAOException {
        int insertedId = -1;
        checkIfCorrectValues(t);
        try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
            List<Object> attributesList = t.attributesToList();
            for (int i = 1; i <= attributesList.size(); i++) {
                ps.setObject(i, attributesList.get(i - 1));
            }
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Treasure" + t.getTreasureName() + " could not be inserted");
            }
            Statement st2 = conn.createStatement();
            ResultSet rs = st2.executeQuery("SELECT COUNT(*) FROM treasures");
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {       
            throw new DAOException(e.getMessage());
        }
        return insertedId;
    }

    private void checkIfCorrectValues(Treasure t) throws DAOException {
        Integer difficulty = t.getDifficulty();
        Double coordinateX = t.getCoordinateX();
        Double coordinateY = t.getCoordinateY();
        Double size = t.getSize();
        if (difficulty != null && difficulty < 0 && difficulty > 10) {
            throw new DAOException("Difficulty field must be between 0 to 10");
        }
        if ( coordinateX != null && coordinateX < -180 && coordinateX > 180) {
            throw new DAOException("Coordinates must be between -180 to 180 ");
        }
        if (coordinateY != null && coordinateY < -180 && coordinateY > 180) {
            throw new DAOException("Coordinates must be between -180 to 180 ");
        }
        if (size < 0) {
            throw new DAOException("Size field must be bigger than 0");
        }
    }

    /**
     * @param fieldMap
     * @throws DAOException
     */
    @Override
    public void modify(Map<String, Object> fieldMap, Integer treasureId) throws DAOException {
        StringBuilder sql = new StringBuilder(UPDATE);
        for (Entry<String, Object> entry : fieldMap.entrySet()) {
            sql.append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                boolean isFieldName = !value.equals(entry.getKey());
                if (isFieldName)
                    sql.append("'");
                sql.append(value);
                if (isFieldName)
                    sql.append("'");

            }
            if (value instanceof Integer) {
                sql.append((int) value);
            }
            if (value instanceof Double) {
                sql.append((double) value);
            }
            sql.append(", ");
        }
        sql.deleteCharAt(sql.length() - 2);
        sql.append("WHERE treasure_id = '" + treasureId + "'");

        try (Statement st = conn.createStatement()) {
            if (st.executeUpdate(sql.toString()) == 0) {
                throw new DAOException("Treasure could not be modified");
            }
        } catch (SQLException e) {
            throw new DAOException("Treasaure could not be modified" + "reson: SQLException: " + e.getMessage());
        }
    }

    /**
     * @param userName
     * @param treasureId
     * @throws DAOException
     */
    @Override
    public void delete(String userName, String treasureId) throws DAOException {
        try (PreparedStatement st = conn.prepareStatement(DELETE)) {
            st.setString(1, treasureId);
            st.setString(2, userName);
            if (st.executeUpdate() == 0) {
                throw new DAOException("Treasure " + treasureId + " from user " + userName +
                " could not be deleted as the given treasureId does not exist or doesn't belong to the user");
            }
        } catch (SQLException e) {
            throw new DAOException("Treasure " + treasureId + " from user " + userName + " could not be deleted");
        }
    }

    @Override
    public List<Treasure> getAll(String userName) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Treasure> treasures = null;
        try {
            ps = conn.prepareStatement(GETALL);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            treasures = new ArrayList<>();
            treasures = resultSetMapperTreasure(rs);
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

    
    private void closePreparedStatement(PreparedStatement ps) throws DAOException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DAOException("SQL error", e);
            }
        }
    }

    /**
     * @param userName
     * @param treasureId
     * @return Treasure
     * @throws DAOException
     */
    @Override
    public Treasure getOne(String userName, Integer treasureId) throws DAOException {
        Treasure selectedTreasure = null;
        try (PreparedStatement ps = conn.prepareStatement(GETONEWITHAUTHOR)) {
            ps.setString(1, treasureId.toString());
            ps.setString(2, userName);
            ResultSet rs = ps.executeQuery();
            List<Treasure> treasureList = resultSetMapperTreasure(rs);
            if (treasureList.isEmpty()) {
                throw new DAOException("Treasure" + treasureId + "does not exist");
            }
            selectedTreasure = treasureList.get(0);
        } catch (SQLException e) {
            throw new DAOException("Treasure" + treasureId + "from user " + userName + "could not be fetched");
        }
        return selectedTreasure;
    }
    
    /**
     * @param userName
     * @param treasureId
     * @return Treasure
     * @throws DAOException
     */
    public Treasure getOne(Integer treasureId) throws DAOException {
        Treasure selectedTreasure = null;
        try (PreparedStatement ps = conn.prepareStatement(GETONE)) {
            ps.setString(1, treasureId.toString());
            ResultSet rs = ps.executeQuery();
            List<Treasure> treasureList = resultSetMapperTreasure(rs);
            if (treasureList.isEmpty()) {
                throw new DAOException("Treasure" + treasureId + "does not exist");
            }
            selectedTreasure = treasureList.get(0);
        } catch (SQLException e) {
            throw new DAOException("Treasure" + treasureId +  "could not be fetched");
        }
        return selectedTreasure;
    }
}
