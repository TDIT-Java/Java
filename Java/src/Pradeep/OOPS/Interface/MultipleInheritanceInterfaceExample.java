package Pradeep.OOPS.Interface;

interface Eating {
    void eat();
}

interface Running {
    void run();
}

class Animal implements Eating, Running {
    @Override
    public void eat() {
        System.out.println("Animal is eating");
    }

    @Override
    public void run() {
        System.out.println("Animal is running");
    }
}

public class MultipleInheritanceInterfaceExample extends Animal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        animal.run();
    }
}
