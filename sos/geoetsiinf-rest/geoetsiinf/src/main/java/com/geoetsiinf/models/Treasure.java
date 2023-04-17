package com.geoetsiinf.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.geoetsiinf.dao.DAOEnums.URIs;

@XmlAccessorType(XmlAccessType.FIELD)
public class Treasure {

    /**
     * @return the dateAdded
     */
    public String getDateAdded() {
        return dateAdded;
    }


    private String treasureName;

    private double coordinateX;

    private double coordinateY;

    private String terrainType;

    private int difficulty;

    private double size;

    private String hint;

    private String authorUserName;

    private String dateAdded;
    private String href;
    private Integer treasureId;



    /**
     * @param treasureName
     * @param coordinateX
     * @param coordinateY
     * @param terrainType
     * @param difficulty
     * @param size
     * @param hint
     */
    public Treasure(String treasureName, double coordinateX, double coordinateY, String terrainType,
            int difficulty, double size, String hint, String authorUserName, String dateAdded, Integer treasureId) {
        this.treasureName = treasureName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.terrainType = terrainType;
        this.difficulty = difficulty;
        this.size = size;
        this.hint = hint;
        this.authorUserName = authorUserName;
        this.dateAdded = dateAdded;
        this.treasureId = treasureId;
        this.href = URIs.TREASURE.toString(treasureId.toString());
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }

    public Treasure() {
        // empty constructor
    }

    /**
     * @param dateAdded the dateAdded to set
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the authorUserName
     */
    public String getAuthorUserName() {
        return authorUserName;
    }

    /**
     * @param authorUserName the authorUserName to set
     */
    public void setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
    }

    /**
     * @return the coordinateX
     */
    public double getCoordinateX() {
        return coordinateX;
    }

    /**
     * @param coordinateX the coordinateX to set
     */
    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * @return the coordinateY
     */
    public double getCoordinateY() {
        return coordinateY;
    }

    /**
     * @param coordinateY the coordinateY to set
     */
    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * @return the terrainType
     */
    public String getTerrainType() {
        return terrainType;
    }

    /**
     * @param terrainType the terrainType to set
     */
    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    /**
     * @return the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return the size
     */
    public double getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * @return the treasureName
     */
    public String getTreasureName() {
        return treasureName;
    }

    /**
     * @param treasureName the treasureName to set
     */
    public void setTreasureName(String treasureName) {
        this.treasureName = treasureName;
    }

    /**
     * @return int
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    /**
     * @return the treasureId
     */
    public Integer getTreasureId() {
        return treasureId;
    }

    /**
     * @param treasureId the treasureId to set
     */
    public void setTreasureId(Integer treasureId) {
        this.href = URIs.TREASURE.toString(treasureId.toString());
        this.treasureId = treasureId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        return result;
    }

    /**
     * @param obj
     * @return boolean
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Treasure))
            return false;
        return true;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Treasure [" + "coordinateX=" + coordinateX + ", coordinateY="
                + coordinateY + ", difficulty=" + difficulty + ", hint=" + hint + ", size=" + size + ", terrainType="
                + terrainType + ", treasureId=" + ", treasureName=" + treasureName + "]";
    }

    /**
     * @return List<Object>
     */
    public List<Object> attributesToList() {
        List<Object> list = new ArrayList<>();
        list.add(this.getTreasureName());
        list.add(this.getCoordinateX());
        list.add(this.getCoordinateY());
        list.add(this.getTerrainType());
        list.add(this.getDifficulty());
        list.add(this.getSize());
        list.add(this.getHint());
        list.add(this.getAuthorUserName());
        return list;
    }

    /**
     * @return Map<String, Object>
     * @throws TreasureModelException
     */
    public Map<String, Object> toMap() throws TreasureModelException {
        Map<String, Object> changesMap = new HashMap<>();

        Object a = this.getTreasureName();
        Object b = this.getCoordinateX();
        Object c = this.getCoordinateY();
        Object d = this.getTerrainType();
        Object e = this.getDifficulty();
        Object f = this.getSize();
        Object g = this.getHint();

        if (a != null)
            changesMap.put("treasure_name", a);
        if (b != null)
            changesMap.put("coordinate_x", b);
        if (c != null)
            changesMap.put("coordinate_y", c);
        if (d != null)
            changesMap.put("terrain_type", d);
        if (e != null)
            changesMap.put("difficulty", e);
        if (f != null)
            changesMap.put("size", f);
        if (g != null)
            changesMap.put("hint", g);
        return changesMap;
    }
}
