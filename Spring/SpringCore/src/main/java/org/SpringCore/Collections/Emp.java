package org.SpringCore.Collections;

import java.util.*;

public class Emp {
    private String name;
    private List<String> phoneNum;
    private Set<String> address;
    private Map<String, String> courses;

    Emp() {
    }

    public Emp(String name, List<String> phoneNum, Set<String> address, Map<String, String> courses) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(List<String> phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public Map<String, String> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", phoneNum=" + phoneNum +
                ", address=" + address +
                ", courses=" + courses +
                '}';
    }
}
