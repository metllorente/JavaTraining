package m4_Activity8;

@FunctionalInterface
public interface BankTestOperation {
    void execute() throws InvalidAmountException, InsufficientFundsException;
}
