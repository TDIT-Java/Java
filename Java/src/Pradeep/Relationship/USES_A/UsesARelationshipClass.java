package Pradeep.Relationship.USES_A;

class Car {
    void start() {
        System.out.println("Car started...");
    }

    void stop() {
        System.out.println("Car stopped...");
    }
}

class Driver {
    // Driver uses a Car temporarily
    void drive(Car car) {
        car.start();
        System.out.println("Driver is driving the car...");
        car.stop();
    }
}

public class UsesARelationshipClass {
    public static void main(String[] args) {
        Car car = new Car();          // Create Car object
        Driver driver = new Driver(); // Create Driver object

        // Driver uses the Car (dependency)
        driver.drive(car);
    }
}
