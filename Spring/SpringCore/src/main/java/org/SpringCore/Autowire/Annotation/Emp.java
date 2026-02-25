package org.SpringCore.Autowire.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
    @Autowired // 1. This is at class/property level
    @Qualifier("address2") // To set the specific bean name if exists multiple
    private Address address;

    Emp(){}

//    @Autowired // 2. This is at constructor level
    Emp(Address address){
        System.out.println("Setting Address through Emp constructor");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

//    @Autowired // 3. This is at method level
    public void setAddress(Address address) {
        System.out.println("Setting Address through Emp ");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "address=" + address +
                '}';
    }
}
