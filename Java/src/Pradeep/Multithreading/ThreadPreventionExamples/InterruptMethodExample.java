package Pradeep.Multithreading.ThreadPreventionExamples;

class ChildTread3 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                if (i == 2) {
                    Thread.sleep(2000);
                }
                System.out.println("Child Tread-" + i);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Tread Interrupted : " + e.getMessage());
        }
    }
}

public class InterruptMethodExample {
    public static void main(String[] args) {
        ChildTread3 childTread3 = new ChildTread3();
//        childTread3.interrupt(); // If we call here then interrupt call will be wasted and program will execute normally
        childTread3.start();
        childTread3.interrupt(); // When targate thread will goes into blocked/waiting state then it is interrupted otherwise it is wasted

        for (int i = 1; i < 5; i++) {
            System.out.println("Main Tread-" + i);
        }
    }
}
