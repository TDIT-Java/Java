package Pradeep.ExceptionHandling.UserDefined.Checked;

// User-defined exception (checked)
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public void checkAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Your are not eligible for vote");
        else {
            System.out.println("Your age is " + age + " so you are eligible for vote");
        }
    }

    public static void main(String[] args) {
        CustomExceptionExample example = new CustomExceptionExample();
        try {
            example.checkAge(10);
        } catch (InvalidAgeException e) {
            System.out.println("Caught exception : " + e.getMessage());
        } finally {
            System.out.println("Closing program");
        }
    }
}
