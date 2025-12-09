package Pradeep.Multithreading.ThreadClass;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is running");
    }
}

public class SetAndGetNameToThread {
    public static void main(String[] args) {
        MyThread threadObj = new MyThread();
//        threadObj.start();
        Thread t1 = new Thread(threadObj, "MyThread");
        t1.start();
        System.out.println("Thread t1 name is " +  t1.getName());
        t1.setName("MyThread-1"); // setName is final synchronized method in Thread class
        System.out.println("After change Thread t1 name is " +  t1.getName()); // getName is final in Thread class
        System.out.println("Main thread name is " + Thread.currentThread().getName()); // currentThread is a static method and its returns the current executing thread
    }
}
