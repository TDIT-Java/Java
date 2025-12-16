package Pradeep.Multithreading.Synchronisation.SynchronizedBlockExample;

class Display2 {
    String name;
    Display2 d;

    public void Display2(String name) {
        System.out.println("Outside Synchronized Block-1 and called by " + Thread.currentThread().getName());
        System.out.println("Outside Synchronized Block-2 and called by " + Thread.currentThread().getName());
        System.out.println("Outside Synchronized Block-3 and called by " + Thread.currentThread().getName());

        synchronized (Display2.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.print("GM: ");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name);
            }
        }

        System.out.println("Outside Synchronized Block-4 and called by " + Thread.currentThread().getName());
        System.out.println("Outside Synchronized Block-5 and called by " + Thread.currentThread().getName());
        System.out.println("Outside Synchronized Block-6 and called by " + Thread.currentThread().getName());
    }
}

class MyThread3 extends Thread {
    String name;
    Display2 d;

    MyThread3(String name, Display2 d) {
        this.name = name;
        this.d = d;
    }

    @Override
    public void run() {
        d.Display2(name);
    }
}

public class BlockLevelLockOnASpecifiedClass {
    public static void main(String[] args) {
        Display2 d = new Display2();
        MyThread3 t1 = new MyThread3("t1", d);
        MyThread3 t2 = new MyThread3("t2", d);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
