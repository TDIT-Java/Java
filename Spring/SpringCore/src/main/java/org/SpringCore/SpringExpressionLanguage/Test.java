package org.SpringCore.SpringExpressionLanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Value("#{10+20}")
    private int x;

    @Value("#{1+20+10*2}")
    private int y;

    // Calling static variable
    @Value("#{ T(java.lang.Math).PI }")
    private double PI;

    // Calling static method
    @Value("#{ T(java.lang.Math).sqrt(25) }")
    private double sqrt;

    // creating new object
    @Value("#{ new java.lang.String('Pradeep') }")
    private String name;

    @Value("#{ 5-1>3 }")
    private boolean isTrue;

    Test() {
    }

    public Test(int x, int y, double PI, double sqrt, String name) {
        this.x = x;
        this.y = y;
        this.PI = PI;
        this.sqrt = sqrt;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getPI() {
        return PI;
    }

    public void setPI(double PI) {
        this.PI = PI;
    }

    public double getSqrt() {
        return sqrt;
    }

    public void setSqrt(double sqrt) {
        this.sqrt = sqrt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                ", PI=" + PI +
                ", sqrt=" + sqrt +
                ", name='" + name + '\'' +
                ", isTrue='" + isTrue + '\'' +
                '}';
    }
}
