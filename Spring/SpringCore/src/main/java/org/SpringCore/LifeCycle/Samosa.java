package org.SpringCore.LifeCycle;

public class Samosa {
    private int price;

    Samosa() {
    }

    public Samosa(int price) {
        this.price = price;
    }

    public int getPrice() {
        System.out.println("Getting Samosa Price");
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Setting Samosa price");
        this.price = price;
    }

    public void init() {
        System.out.println("Samosa init");
    }

    public void destroy() {
        System.out.println("Samosa destroy");
    }

    @Override
    public String toString() {
        return "Samosa{" + "price=" + price + '}';
    }
}
