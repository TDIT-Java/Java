package org.Java.Model;

public class Person {
    private int id;
    private String name;
    private String mobileNo;
    private String email;
    private String address;
    private String gender;
    private boolean isAlive;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(int id, String name, String mobileNo, String email,
                  String address, String gender, boolean isAlive) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.isAlive = isAlive;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    // For display purposes
    public String getStatus() {
        return isAlive ? "Alive" : "Deceased";
    }
}
