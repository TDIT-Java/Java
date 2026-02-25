package org.SpringCore.Standalone.Collections;

import java.util.*;

public class Person {
    private List<String> friends;
    private Map<String, Integer> feesStructure;
    private Properties properties;

    Person(){}

    public Person(List<String> friends, Map<String, Integer> feesStructure, Properties properties) {
        this.friends = friends;
        this.feesStructure = feesStructure;
        this.properties = properties;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, Integer> getFeesStructure() {
        return feesStructure;
    }

    public void setFeesStructure(Map<String, Integer> feesStructure) {
        this.feesStructure = feesStructure;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "friends=" + friends +
                ", feesStructure=" + feesStructure +
                ", properties=" + properties +
                '}';
    }
}
