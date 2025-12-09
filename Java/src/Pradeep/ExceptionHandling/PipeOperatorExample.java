package Pradeep.ExceptionHandling;

public class PipeOperatorExample {
    public static void main(String[] args) {
        try {
            String name = null;
            int[] a = new int[3];
            System.out.println(10 / 0);
            System.out.println(name.length());
            System.out.println(a[4]);
        } catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
    }
}

// Rule No. 1:
// There should be no relation when using pipe operator to handle exception in between
// exceptions like IndexOutOfBoundsException is a parent of ArrayIndexOutOfBoundsException
// so either parent is valid or child both cannot excepted.


// NOTE: If you used Pipe operator then use another catch block so that if any other exception occered
// then it will handle. (Standard)