package org.SpringCore.LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean {
    private int price;

    Pepsi() {
    }

    public Pepsi(int price) {
        this.price = price;
    }

    public int getPrice() {
        System.out.println("Getting Pepsi price");
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Setting Pepsi price");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pepsi{" +
                "price=" + price +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Pepsi init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Pepsi destroy");
    }
}
