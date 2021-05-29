package shared.Reservation;


import java.io.Serializable;

/**
 * @author Oliver, tymon
 * @version 1.0
 * class to store address from Reservation class,
 * implements Serializable so it can be passed between
 * client and server
 */
public class Address implements Serializable {
    private String city;
    private String street;
    private String zip;
    private String country;

    /**
     * public constructor
     * @param street String
     * @param city String
     * @param zip String
     * @param country String
     */
    public Address(String street, String city, String zip, String country) {
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.country = country;
    }

    /**
     * gets city
     * @return city as String
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * gets Street
     * @return street as String
     */
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * gets zip
     * @return zip as String
     */
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * gets country
     * @return country as String
     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    /**
     *
     * @return all fields as a single String
     */
    public String toString() {
        return street + ", " + zip + ", " + city + ", " + country;
    }
}

