package es.upm.fi.sos;

public class MyTreasure {
    private String name;
    private double latitude;
    private double longitude;

    public MyTreasure(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object treasure) {
        if(!(treasure instanceof MyTreasure)) {
            return false;
        }
        MyTreasure myTreasure = (MyTreasure)treasure;
        return myTreasure.getName().equals(this.name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

}
