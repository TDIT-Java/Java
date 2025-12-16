package Pradeep.Multithreading.Synchronisation.SynchronizedBlockExample;

class Display1 {
    public void Display1(String name, Display1 d) {
        System.out.println("Outside synchronised-1 and calling by " + Thread.currentThread().getName());
        System.out.println("Outside synchronised-2 and calling by " + Thread.currentThread().getName());
        System.out.println("Outside synchronised-3 and calling by " + Thread.currentThread().getName());

        synchronized (d) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.print("Gm: ");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name);
            }
        }

        System.out.println("Outside synchronised-4 and calling by " + Thread.currentThread().getName());
        System.out.println("Outside synchronised-5 and calling by " + Thread.currentThread().getName());
        System.out.println("Outside synchronised-6 and calling by " + Thread.currentThread().getName());
    }
}

class MyThread1 extends Thread {
    Display1 d;
    String name;

    MyThread1(String name, Display1 d) {
        this.name = name;
        this.d = d;
    }

    @Override
    public void run() {
        d.Display1(name, d);
    }
}

public class BlockLevelLockOnASpecifiedObject {
    public static void main(String[] args) {
        Display1 d = new Display1();
        MyThread1 t1 = new MyThread1("ABC", d);
        MyThread1 t2 = new MyThread1("XYZ", d);
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();
    }
}
