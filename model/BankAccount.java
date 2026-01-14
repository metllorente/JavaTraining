package m4_Activity9.model;

public class BankAccount {
	
	private String accountNumber;
	private String ownerName;
	private double balance;

	public BankAccount(String accountNumber, String ownerName, double balance) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("Account number cannot be null or empty");
		}
		if (ownerName == null || ownerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Owner name cannot be null or empty");
		}
		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative");
		}

		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > this.balance) {
			throw new IllegalArgumentException("Insufficient funds");
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return String.format("BankAccount[accountNumber=%s, owner=%s, balance=%.2f]", accountNumber, ownerName,
				balance);
	}
	
}
