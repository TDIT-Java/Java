package Pradeep.ExceptionHandling.BuildIn.Checked;

public class ThrowsExample {
    public void add() throws ArithmeticException {
        System.out.println(1 / 0);
    }

    public static void main(String[] args) {
        ThrowsExample obj = new ThrowsExample();
        try {
            obj.add();
        } catch (Exception e) {
            throw new ArithmeticException("Cannot devide by zero");
        }
    }
}
