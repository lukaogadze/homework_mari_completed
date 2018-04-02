package userapp;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(){

    }

    public Address(String street, String suite, String city, String zipcode, Geo geo){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet(){
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }

    public void setGeo(Geo geo){
        this.geo = geo;
    }

    @Override
    public String toString(){
        return String.format("[street : %s, suite : %s, city : %s, zipcode : %s, geo : %s]"
                ,this.street,this.suite,this.city,this.zipcode,this.geo.toString());
    }

}
