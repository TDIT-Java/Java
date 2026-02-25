package org.SpringCore.Autowire;

public class Emp {
    private Address address;

    Emp(){}

    Emp(Address address){
        System.out.println("Setting Address through Emp constructor");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("Setting Address");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "address=" + address +
                '}';
    }
}
