package Pradeep.Multithreading.ThreadClass;

class StartMethodOverride extends Thread {
    @Override
    public synchronized void start() {
        super.start(); // When super.start() will execute then only thread will be initialized and Thread class strat will be called
        System.out.println("Start Method Overridden is running");
    }

    @Override
    public void run() {
        System.out.println("Run method is running");
    }
}

public class OverridingStartMethod {
    public static void main(String[] args) {
        StartMethodOverride StartMethodOverrideObj =  new StartMethodOverride();
        StartMethodOverrideObj.start();
        System.out.println("Main Thread is running");
    }
}
