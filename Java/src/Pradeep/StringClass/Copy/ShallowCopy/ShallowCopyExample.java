package Pradeep.StringClass.Copy.ShallowCopy;

class Car {
    String name;

    Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name of the Car: " + name;
    }
}

class Bike implements Cloneable {
    String name;
    Car car;

    Bike(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Name of the Bike: " + name + " And Car: " + car;
    }
}

public class ShallowCopyExample {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        Bike bike = new Bike("Activa", car);

        try {
            Bike copiedBike = (Bike) bike.clone();

            System.out.println("Original bike: " + bike);
            System.out.println("Copied bike: " + copiedBike);

            copiedBike.car.name = "Tata";

            System.out.println("\nAfter modifying car name:");
            System.out.println("After change car name original car: " + car);
            System.out.println("After change car name: " + copiedBike);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
