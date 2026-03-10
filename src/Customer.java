public class Customer {
    private String name, streetAddress, city, state, country, zipcode;
    public Customer(String name, String streetAddress, String city, String state, String country, String zip) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zip;
    }
    public String GetName() {
        return name;
    }
    public String GetStreetAddress() {
        return streetAddress;
    }
    public String GetCity() {
        return city;
    }
    public String GetState() {
        return state;
    }
    public String GetCountry() {
        return country;
    }
    public String GetZipcode() {
        return zipcode;
    }
    public String GetFullAddress() {
        return streetAddress + ", " + city + ", " + state + ", " + country + ", " + zipcode;
    }
}
