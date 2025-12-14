package Pradeep.Multithreading.Synchronisation;

class Job {
    public synchronized void wish(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.print("GM: ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(name);
        }
    }
}

class MyThread extends Thread {
    Job j;
    String name;

    MyThread(String name, Job j) {
        this.j = j;
        this.name = name;
    }

    @Override
    public void run() {
        j.wish(name);
    }
}

public class SynchronisationExample {
    public static void main(String[] args) {
        Job j1 = new Job();
        MyThread t1 = new MyThread("Abc", j1);
        MyThread t2 = new MyThread("Xyz", j1);

        t1.start();
        t2.start();
    }
}
