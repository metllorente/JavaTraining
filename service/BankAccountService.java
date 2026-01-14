package m4_Activity9.service;

import m4_Activity9.exception.AccountNotFoundException;
import m4_Activity9.exception.InsufficientFundsException;
import m4_Activity9.exception.InvalidAccountException;
import m4_Activity9.exception.InvalidTransferException;
import m4_Activity9.model.BankAccount;

// TODO 1: Import Logger and create a logger for this class
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BankAccountService {
    
    // TODO 1 (continued): Logger instance
    private static final Logger logger = LoggerFactory.getLogger(BankAccountService.class);

    private static final double MINIMUM_INITIAL_BALANCE = 0.0;
    private List<BankAccount> accounts = new ArrayList<>();

    /**
     * Creates a new bank account.
     */
    public void createAccount(String accountNumber, String ownerName, double initialBalance)
            throws InvalidAccountException {

        // TODO 2: Log INFO message
        logger.info("Creating account for owner: {}", ownerName);

        // Validate account number
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            // TODO 3: Log WARN
            logger.warn("Account creation failed: account number is null or empty");
            // TODO 4: Throw Exception
            throw new InvalidAccountException("Account number cannot be null or empty");
        }

        // Validate owner name
        if (ownerName == null || ownerName.trim().isEmpty()) {
            // TODO 5: Log WARN
            logger.warn("Account creation failed: owner name is null or empty");
            // TODO 6: Throw Exception
            throw new InvalidAccountException("Owner name cannot be null or empty");
        }

        // Validate initial balance
        if (initialBalance < MINIMUM_INITIAL_BALANCE) {
            // TODO 7: Log WARN
            logger.warn("Account creation failed: invalid initial balance {}", initialBalance);
            // TODO 8: Throw Exception with formatted message
            throw new InvalidAccountException(String.format(
                "Initial balance must be at least %.2f. Received: %.2f", MINIMUM_INITIAL_BALANCE, initialBalance));
        }

        // Check for duplicate account
        if (accountExists(accountNumber)) {
            // TODO 9: Log WARN
            logger.warn("Account creation failed: account {} already exists", accountNumber);
            // TODO 10: Throw Exception
            throw new InvalidAccountException("Account number already exists: " + accountNumber);
        }

        // Create account
        try {
            BankAccount account = new BankAccount(accountNumber, ownerName, initialBalance);
            accounts.add(account);
            // TODO 11: Log INFO
            logger.info("Account {} created successfully for {}", accountNumber, ownerName);

        } catch (IllegalArgumentException e) {
            // TODO 12: Log ERROR with exception object
            logger.error("Failed to create account due to invalid arguments", e);
            // TODO 13: Throw Exception with original cause
            throw new InvalidAccountException("Account creation failed", e);
        }
    }

    /**
     * Transfers money between accounts.
     */
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, InvalidTransferException {

        // TODO 14: Log INFO
        logger.info("Transfer request: {} -> {}, amount: {}", fromAccountNumber, toAccountNumber, amount);

        // Validate amount
        if (amount <= 0) {
            // TODO 15: Log WARN
            logger.warn("Transfer failed: invalid amount {}", amount);
            // TODO 16: Throw Exception
            throw new InvalidTransferException(String.format("Transfer amount must be positive. Received: %.2f", amount));
        }

        // Validate accounts are different
        if (fromAccountNumber.equals(toAccountNumber)) {
            // TODO 17: Log WARN
            logger.warn("Transfer failed: same source and destination account {}", fromAccountNumber);
            // TODO 18: Throw Exception
            throw new InvalidTransferException("Cannot transfer from account " + fromAccountNumber + " to itself");
        }

        // Find source account
        BankAccount fromAccount = findAccountByNumber(fromAccountNumber);
        if (fromAccount == null) {
            // TODO 19: Log WARN
            logger.warn("Transfer failed: source account {} not found", fromAccountNumber);
            // TODO 20: Throw Exception
            throw new AccountNotFoundException("Source account not found: " + fromAccountNumber);
        }

        // Find destination account
        BankAccount toAccount = findAccountByNumber(toAccountNumber);
        if (toAccount == null) {
            // TODO 21: Log WARN
            logger.warn("Transfer failed: destination account {} not found", toAccountNumber);
            // TODO 22: Throw Exception
            throw new AccountNotFoundException("Destination account not found: " + toAccountNumber);
        }

        // Check sufficient funds
        if (fromAccount.getBalance() < amount) {
            // TODO 23: Log WARN
            logger.warn("Transfer failed: insufficient funds in account {}. Balance: {}, Required: {}", 
                fromAccountNumber, fromAccount.getBalance(), amount);
            // TODO 24: Throw Exception
            throw new InsufficientFundsException(String.format(
                "Insufficient funds. Balance: %.2f, Required: %.2f", fromAccount.getBalance(), amount));
        }

        // Perform transfer
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            // TODO 25: Log INFO
            logger.info("Transfer successful: {} -> {}, amount: {}", fromAccountNumber, toAccountNumber, amount);

        } catch (Exception e) {
            // TODO 26: Log ERROR
            logger.error("Transfer failed due to unexpected error", e);
            // TODO 27: Throw Exception
            throw new InvalidTransferException("Transfer failed", e);
        }
    }

    /**
     * Finds account by account number.
     */
    private BankAccount findAccountByNumber(String accountNumber) {
        if (accountNumber == null) {
            return null;
        }

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                // TODO 28: Log DEBUG
                logger.debug("Account found: {}", accountNumber);
                return account;
            }
        }
        // TODO 29: Log DEBUG
        logger.debug("Account not found: {}", accountNumber);
        return null;
    }

    private boolean accountExists(String accountNumber) {
        return findAccountByNumber(accountNumber) != null;
    }

    public List<BankAccount> getAllAccounts() {
        // TODO 30: Log DEBUG
        logger.debug("Retrieving all accounts, count: {}", accounts.size());
        return new ArrayList<>(accounts);
    }
}