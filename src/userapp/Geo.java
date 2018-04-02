package userapp;


public class Geo extends java.lang.Object {

    private String lat;
    private String lng;

    public Geo(){

    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        // String format = String.format("[lat : %s, lng : %s]",this.lat,this.lng);
        String nonFormat = "[lat : " + this.lat + ", lng : " + this.lng + "]";
        return nonFormat;
    }

}
