package Pradeep.Multithreading.ThreadClass;

class ThreadClassDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread-0 is running");
        }
    }
}

public class ThreadClassExample {
    public static void main(String[] args) {
        ThreadClassDemo threadClassExampleObj = new ThreadClassDemo();
        threadClassExampleObj.start(); // start method of Thread class will be called
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread is running");
        }
//        threadClassExampleObj.run(); // direct run method is also valid but it will perform just like normal method
//        Thread t = new Thread(threadClassExampleObj); // this is also valid
//        t.start(); // this will start call the run method of ThreadClassDemo class
//        t.run(); // This will call Thread class run method but nothing will print
    }
}
