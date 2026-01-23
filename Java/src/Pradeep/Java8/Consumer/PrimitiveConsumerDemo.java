package Pradeep.Java8.Consumer;

import java.util.function.*;

public class PrimitiveConsumerDemo {
    public static void main(String[] args) {
        IntConsumer c = i -> System.out.println(i);
        c.accept(1);

        DoubleConsumer d = i -> System.out.println(i);
        d.accept(11.2234);

        LongConsumer l = i ->  System.out.println(i);
        l.accept(1111111111111111111l);
    }
}
