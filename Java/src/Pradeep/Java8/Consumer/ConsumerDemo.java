package Pradeep.Java8.Consumer;

import java.util.function.*;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> c = x -> System.out.println("Value of x is " + x);
        Consumer<Integer> cc = x -> System.out.println("Value of x*2 is " + (x * 2));
        c.accept(5);
        c.andThen(cc).accept(1);
    }
}
