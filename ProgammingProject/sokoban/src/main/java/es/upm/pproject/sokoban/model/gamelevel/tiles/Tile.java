package es.upm.pproject.sokoban.model.gamelevel.tiles;

/**
 * The class that creates a tile. A tile can be of different TileTypes (enum).
 */
public class Tile {

    private TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    
    /** 
     * @return TileType
     */
    public TileType getTileType() {
        return type;
    }

    
    /** 
     * @param type
     */
    public void setTileType(TileType type) {
        this.type = type;
    }

    
    /** 
     * @return int
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        if (!(obj instanceof Tile))
            return false;
        Tile other = (Tile) obj;
        return type == other.type;
    }

}
