package jpa.mapping.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedAddress {
    String street;
    String city;
    String state;
    String zip;

    public EmbeddedAddress() {
    }

    public EmbeddedAddress(String street, String city, String state, String zip) {
        super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
