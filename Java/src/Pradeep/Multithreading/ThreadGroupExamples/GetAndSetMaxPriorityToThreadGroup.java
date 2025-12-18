package Pradeep.Multithreading.ThreadGroupExamples;

public class GetAndSetMaxPriorityToThreadGroup {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("First Thread Group");

        System.out.println(tg.getMaxPriority());

        Thread t1 = new Thread(tg, "First Thread");
        Thread t2 = new Thread(tg, "Second Thread");

        tg.setMaxPriority(3);

        Thread t3 = new Thread(tg, "Third Thread");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        System.out.println(tg.getMaxPriority());

    }
}
