package Pradeep.Multithreading.DeadLockExample;

class A {
    public synchronized void d1(B b) {
        System.out.println("Thread 1 is started running d1 method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thread 1 going to call B's last method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A's last method");
    }
}

class B {
    public synchronized void d2(A a) {
        System.out.println("Thread 2 is started running d2 method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thread 2 going to call A's last method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B's last method");
    }
}

public class DeadLockUsingSyncMethod extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);
    }

    @Override
    public void run() {
        b.d2(a);
    }

    public static void main(String[] args) {
        DeadLockUsingSyncMethod dl = new DeadLockUsingSyncMethod();
        dl.m1();
    }
}
