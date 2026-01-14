package m4_Activity7;

public class InsufficientFundsException extends Exception {
    private final double balance;
    private final double requestedAmount;

    public InsufficientFundsException(String message, double balance, double requestedAmount) {
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}
