package Pradeep.ExceptionHandling.BuildIn.Checked;

public class ThrowExample {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Arithmetic Exception");
        } finally {
            System.out.println("Inside finally block");
            throw new ArithmeticException("Arithmetic Exception");
        }

    }
}
