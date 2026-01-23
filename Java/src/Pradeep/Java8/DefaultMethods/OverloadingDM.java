package Pradeep.Java8.DefaultMethods;

interface test1 {
    default void say() {
        System.out.println("Hello World");
    }

    default void say(String s) {
        System.out.println(s);
    }
}

public class OverloadingDM implements test1 {
    public static void main(String[] args) {
        OverloadingDM obj = new OverloadingDM();
        obj.say();
        obj.say("How are you");
    }
}
