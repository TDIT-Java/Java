package Pradeep.StringClass.Copy.DeepCopy;

class Car{

    String name;

    Car(String name){
        this.name = name;

    }

    Car(Car other){
        this.name = other.name;
    }
}

class Bike{
    String name;
    Car car;

    Bike(String name, Car car){
        this.name = name;
        this.car = car;
    }

    Bike(Bike other){
        this.name = other.name;
        this.car = new Car(other.name);
    }
}

public class DeepCopyExample{
    public static void main(String[] args){
        Car c1 = new Car("BMW");
        Bike b1 = new Bike("MAT", c1);

        Bike b2 = new Bike(b1);

        System.out.println("Original Name: " + b1.car.name);
        System.out.println("Copied Name: " + b2.car.name);

        b2.car.name = "Mercedize";

        System.out.println("\nAfter modification:");
        System.out.println("Original Name: " + b1.car.name);
        System.out.println("Copied Name: " + b2.car.name);
    }
}

