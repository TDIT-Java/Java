package Pradeep.Multithreading.Priority;

class MyThread extends Thread {}

public class SetAndGetPriorityExample {
    public static void main(String[] args) {
        System.out.println("Main Thread Priority is " + Thread.currentThread().getPriority());
        MyThread t1 = new MyThread();
        System.out.println("MyThread Thread Priority before setting is : " + t1.getPriority());
//        t1.setPriority(15); // Will get RuntimeException saying IllegalArgumentException
        t1.setPriority(10);
        System.out.println("MyThread Priority after setting to 10 is : " + t1.getPriority());
    }
}

//Rule 1:
// We can set priority from 1 to 10 only and 1 is min and 10 is max and 5 is normal priority
