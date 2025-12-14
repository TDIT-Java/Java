package Pradeep.Multithreading.ThreadPreventionExamples;

class ChildThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class WaitingMainThreadUntillChildThreadComplete {
    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        childThread.start();
        try {
            childThread.join();
        } catch (InterruptedException e) {
            System.out.println("Caught Exception " + e.getMessage());;
        }

        for(int i = 0; i < 5; i++) {
            System.out.println("main Thread " + i);
        }
    }
}
