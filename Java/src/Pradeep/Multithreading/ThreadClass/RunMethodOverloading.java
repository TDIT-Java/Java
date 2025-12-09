package Pradeep.Multithreading.ThreadClass;

class RunOverloading extends Thread {
    @Override
    public void run() {
        System.out.println("no-args run called");
    }

    public void run(int i) {
        System.out.println("Thread-"+ i +" is running");
    }
}

public class RunMethodOverloading {
    public static void main(String[] args) {
        RunOverloading  obj = new RunOverloading();
        obj.start();
        obj.run(1); // This will run like normal thread and also start() will not call to this auto.
        System.out.println("Main Thread is running");
    }
}
