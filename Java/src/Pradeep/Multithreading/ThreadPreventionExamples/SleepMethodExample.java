package Pradeep.Multithreading.ThreadPreventionExamples;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Value of i is " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class SleepMethodExample {
    public static void main(String[] args) {
        MyThread example = new MyThread();
        example.start();
    }
}
