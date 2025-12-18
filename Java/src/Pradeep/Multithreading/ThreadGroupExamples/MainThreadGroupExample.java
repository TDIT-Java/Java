package Pradeep.Multithreading.ThreadGroupExamples;

public class MainThreadGroupExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
