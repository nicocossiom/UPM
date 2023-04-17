package com.geoetsiinf.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Treasure {
    private float coordinateX;
    private float coordinateY;
    private int treasureId;
    private String terrainType;
    private int difficulty;
    private float size;
    private String hint;
    private String authorUserName;
    private String treasureName;
    public String dateAdded;
    public String href;
    // private List<Pair<User, Date>> foundList;  
    
    public String getHref() {
		return href;
	}
    public void setHref(String href) {
    	this.href = href;
    }
	/**
     * @param treasureName
     * @param coordinateX
     * @param coordinateY
     * @param terrainType
     * @param difficulty
     * @param size
     * @param hint
     * @param authorUserName
     */
    public Treasure(String treasureName, float coordinateX, 
    		float coordinateY, String terrainType,
                    int difficulty, float size, String hint, 
                    String authorUserName) {
        this.treasureName = treasureName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.terrainType = terrainType;
        this.difficulty = difficulty;
        this.size = size;
        this.hint = hint;
        this.authorUserName = authorUserName;
        this.dateAdded = (new Date()).toString(); // gets current_date
    }
    public Treasure() {
    }
    /**
     * @return the coordinateX
     */
    public float getCoordinateX() {
        return coordinateX;
    }
    /**
     * @param coordinateX the coordinateX to set
     */
    public void setCoordinateX(float coordinateX) {
        this.coordinateX = coordinateX;
    }
    /**
     * @return the coordinateY
     */
    public float getCoordinateY() {
        return coordinateY;
    }
    /**
     * @param coordinateY the coordinateY to set
     */
    public void setCoordinateY(float coordinateY) {
        this.coordinateY = coordinateY;
    }
    /**
     * @return the treasureId
     */
    public int getTreasureId() {
        return treasureId;
    }
    /**
     * @param treasureId the treasureId to set
     */
    public void setTreasureId(int treasureId) {
        this.treasureId = treasureId;
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
    public float getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(float size) {
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
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + treasureId;
        return result;
    }
    
    /** 
     * @param obj
     * @return boolean
     */
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Treasure))
            return false;
        Treasure other = (Treasure) obj;
        if (treasureId != other.treasureId)
            return false;
        return true;
    }
    
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Treasure [authorUserName=" + authorUserName + ", coordinateX=" + coordinateX + ", coordinateY="
                + coordinateY + ", difficulty=" + difficulty + ", hint=" + hint + ", size=" + size + ", terrainType="
                + terrainType + ", treasureId=" + treasureId + ", treasureName=" + treasureName + "]";
    }

    
    /** 
     * @return List<Object>
     */
    public List<Object> attributesToList() {
        List<Object> list = new ArrayList<Object>();
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
     */
    public Map<String, Object> toMap() {
        Map<String, Object> changesMap = new HashMap<String, Object>();

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
            changesMap.put("coordinate_y", d);
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
