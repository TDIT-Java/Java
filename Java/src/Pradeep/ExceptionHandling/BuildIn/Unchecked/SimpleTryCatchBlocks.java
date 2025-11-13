package Pradeep.ExceptionHandling.BuildIn.Unchecked;

public class SimpleTryCatchBlocks {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            {
                System.out.println("Inside try block {}");
            }
            try {
                System.out.println("Inside nested try block 1");
            } finally {
                System.out.println("Inside nested finally block 1");
            }
        } catch (Exception e) {
            System.out.println("Caught Exception " + e);
        } finally {
            System.out.println("Inside finally block");
            try {
                System.out.println("Inside finally try block");
            } finally {
                System.out.println("Inside finally finally block");
            }
        }
    }
}
