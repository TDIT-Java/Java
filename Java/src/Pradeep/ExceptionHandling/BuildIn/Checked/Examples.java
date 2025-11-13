package Pradeep.ExceptionHandling.BuildIn.Checked;

public class Examples {
    public static void main(String[] args) throws ArithmeticException {
        Throwable ee = new ArithmeticException("This is a test");
        System.out.println(ee);

        try {
            System.out.println("Inside try");
            System.out.println(1 / 0);
        }
        catch (ArithmeticException e) {
            System.out.println("Inside catch");
            System.out.println(e.getMessage());
            try{
                System.out.println("Inside try try");
                System.out.println(1 / 0);
            }
            catch(Exception e1){
                System.out.println("Inside catch catch");
                System.out.println(e1.getMessage());
            }
            finally{
                System.out.println("Inside finally finally");
                throw new ArithmeticException("Cannot devide by 0");
            }
        }
        finally {
            System.out.println("inside finally");
            throw new ArithmeticException("Cannot devide by zero"); // overridden
        }
    }
}
