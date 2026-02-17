package org.SpringCore.RefInjection;

public class B {
    private int y;

    B(){}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "B{" +
                "y=" + y +
                '}';
    }
}
