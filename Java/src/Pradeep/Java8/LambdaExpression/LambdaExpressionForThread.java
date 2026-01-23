package Pradeep.Java8.LambdaExpression;

public class LambdaExpressionForThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Child Thread");
            }
        });

        t1.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread");
        }
    }
}
