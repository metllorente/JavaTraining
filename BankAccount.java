package m4_Activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
	private static final Logger log = LoggerFactory.getLogger(BankAccount.class);
    private double balance = 10000.0;
    
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        log.info("Withdrawal requested: ₱{}", amount);

        if (amount < 0) {
            log.error("Invalid withdrawal amount: ₱{}", amount);
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            log.warn("Insufficient funds: ₱{} available", balance);
            throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
        }

        balance -= amount;
        log.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        log.info("Deposit requested: ₱{}", amount);

        if (amount <= 0) {
            log.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit amount must be positive");
        }

        if (amount > 50_000) {
            log.warn("Large deposit: ₱{} - requires verification", amount);
        }

        balance += amount;
        log.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
    }
    
    public static void runTest(BankTestOperation operation, String operationName) {
        try {
            operation.execute();
        } catch (InvalidAmountException e) {
            log.error("{} failed: {}", operationName, e.getMessage(), e);
        } catch (InsufficientFundsException e) {
            log.error("{} failed: {}", operationName, e.getMessage(), e);
        }
    }
}
