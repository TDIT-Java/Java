package Pradeep.Java8.LambdaExpression;

//@FunctionalInterface
interface Cal {
    public void add(int a, int b);

    default void sub() {
        System.out.println("Substration");
    }

    static void mul() {
        System.out.println("Multiplication");
    }
}

public class LambdaExpressionFirst {
    public static void main(String[] args) {
        Cal c = (a, b) -> System.out.println(1 + 2);

        c.add(1, 2);
        c.sub();
        Cal.mul();
    }
}
