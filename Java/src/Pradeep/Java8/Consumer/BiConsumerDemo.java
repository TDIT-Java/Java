package Pradeep.Java8.Consumer;

import java.util.function.*;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (x, y) -> System.out.println(x + y);
        BiConsumer<String, String> biConsumer1 = (x, y) -> System.out.println("Length of x is " + x.length() + " and y is " + y.length());

        biConsumer.andThen(biConsumer1).accept("Abc", "XyzZ");
    }
}
