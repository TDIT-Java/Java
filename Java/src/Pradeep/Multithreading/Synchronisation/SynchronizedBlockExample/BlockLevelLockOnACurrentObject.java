package Pradeep.Multithreading.Synchronisation.SynchronizedBlockExample;

class Display {
    public void display(String name) {
        System.out.println("This is outside synchronised block-1");
        System.out.println("This is outside synchronised block-2");
        System.out.println("This is outside synchronised block-3");
        System.out.println("This is outside synchronised block-4");
        System.out.println("This is outside synchronised block-5");

        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Hello ");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name);
            }
        }

        System.out.println("This is outside synchronised block-6");
        System.out.println("This is outside synchronised block-7");
        System.out.println("This is outside synchronised block-8");
        System.out.println("This is outside synchronised block-9");
        System.out.println("This is outside synchronised block-10");
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.display(name);
    }
}

public class BlockLevelLockOnACurrentObject {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Abc");
        MyThread t2 = new MyThread(d, "Xyz");
        t1.start();
        t2.start();
    }
}
