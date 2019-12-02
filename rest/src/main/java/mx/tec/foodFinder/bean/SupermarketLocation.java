package mx.tec.foodFinder.bean;

public class SupermarketLocation {
    private String supermarket;
    private double latitude,longitude;

    public SupermarketLocation() { }

    public SupermarketLocation(String supermarket, double latitude, double longitude) {
        this.supermarket = supermarket;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSupermarket() { return supermarket; }
    public void setSupermarket(String supermarket) { this.supermarket = supermarket; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString() {
        return "SupermarketLocation{" +
                "supermarket='" + supermarket + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
