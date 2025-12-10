package Pradeep.Multithreading.Priority;

class ChildThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class PriorityExample {
    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        childThread.setPriority(10);
        childThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}
