package Homework03;

public class Entry1 implements Comparable<Entry1> {
    String name;
    String streetAddress;
    String city;
    String postcode;
    String country;
    String phoneNumber;

    public Entry1(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public int compareTo(Entry1 other) {
        return this.name.compareTo(other.name);
    }
    public String toString(){
        return "Name: " + this.name + "\n" +  "Street Address: " + this.streetAddress + "\n" + "City: " + this.city + "\n" + "Postal code: " + this.postcode + "\n" + "Country: " + this.country + "\n" + "Phone Number: " + this.phoneNumber;
    }
}