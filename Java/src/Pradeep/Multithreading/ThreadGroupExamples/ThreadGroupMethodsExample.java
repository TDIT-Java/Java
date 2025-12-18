package Pradeep.Multithreading.ThreadGroupExamples;

class  MyThread extends Thread {
    MyThread(ThreadGroup g, String name) {
        super(g, name);
    }

    @Override
    public void run() {
        System.out.println("MyThread run");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Caught InterruptedException: "+ e.getMessage());
        }
    }
}

public class ThreadGroupMethodsExample {
    public static void main(String[] args) throws Exception {
        ThreadGroup tg = new ThreadGroup("First Thread Group");
        ThreadGroup tg2 = new ThreadGroup(tg, "Child First Thread Group");

        System.out.println("Name of tg group: " +  tg.getName());
        tg.setMaxPriority(3);
        System.out.println("Max Priority: " + tg.getMaxPriority());
        System.out.println("Parent of tg Thread Group: " + tg.getParent());

        MyThread t1 = new MyThread(tg, "First Thread");
        MyThread t2 = new MyThread(tg, "Second Thread");
        t1.start();
        t2.start();

        System.out.println(tg.activeCount());
        System.out.println(tg.activeGroupCount());
        tg.list();
        Thread.sleep(10000);
        System.out.println(tg.activeCount());
        System.out.println(tg.activeGroupCount());
        tg.list();
        tg.destroy();
    }
}
