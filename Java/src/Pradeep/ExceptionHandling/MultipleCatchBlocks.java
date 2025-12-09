package Pradeep.ExceptionHandling;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            String name = null;
            int[] a = new int[3];
            System.out.println(10 / 0);
            System.out.println(name.length());
            System.out.println(a[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// RULE 1:
// Parent exception always should be written at last, because if we write parent first
// then child will be no use or unreachable