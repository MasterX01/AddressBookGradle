package com.bridgelabz;

public class Person {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    int zipInt;
    String pNo;
    long pNoInt;
    String email;
    String type;

    public Person(String firstName, String lastName, String address, String city, String state, int zipInt, long pNoInt, String email, String type){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipInt=zipInt;
        this.pNoInt=pNoInt;
        this.email=email;
        this.type=type;
    }

    public Person(){
        
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public int getZipInt() {
        return zipInt;
    }
    public void setZipInt(int zip) {
        this.zipInt = zip;
    }

    public String getpNo() {
        return pNo;
    }
    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public long getpNoInt() {
        return pNoInt;
    }
    public void setpNoInt(Long pNo) {
        this.pNoInt = pNo;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phone=" + pNo +
                ", email='" + email + '\'' +
                '}';
    }
}
