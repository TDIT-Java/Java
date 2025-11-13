package Pradeep.ExceptionHandling.UserDefined.UnChecked;

// // User-defined exception (unchecked)
class InsufficientFundException extends RuntimeException {
    InsufficientFundException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public void CheckWithdrawFund(int availableBalance, int withdrawamount) throws InsufficientFundException {
        if (availableBalance < withdrawamount) {
            throw new InsufficientFundException("Insufficient Fund");
        } else {
            System.out.println("You can withdraw");
        }
    }

    public static void main(String[] args) {
        try {
            CustomExceptionExample example = new CustomExceptionExample();
            example.CheckWithdrawFund(100, 200);
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
    }
}
