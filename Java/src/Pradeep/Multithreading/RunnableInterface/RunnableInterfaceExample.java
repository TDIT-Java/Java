package Pradeep.Multithreading.RunnableInterface;

class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyRunnableThread run");
        }
    }
}

public class RunnableInterfaceExample {
    public static void main(String[] args) {
        MyRunnableThread myRunnableThreadObj = new MyRunnableThread();
        Thread t1 = new Thread(myRunnableThreadObj);
        t1.start(); // Thread class start method will be called
//        myRunnableThreadObj.run(); // Called like normal method
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread run");
        }
    }
}
