package Pradeep.Multithreading.ThreadGroupExamples;

public class ThreadGroupConstructorsExample {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("First Thread Group");
        System.out.println("First Name of Thread Group "+ tg.getName() + " and parent is " + tg.getParent().getName());

        ThreadGroup tg1 = new ThreadGroup("Second Thread Group");
        System.out.println("Second Name of Thread Group "+ tg1.getName() + " and parent is " + tg1.getParent().getName());

    }
}
