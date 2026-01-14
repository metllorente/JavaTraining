package m4_Activity8;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        BankAccount.runTest(() -> account.deposit(5000), "Deposit");
        BankAccount.runTest(() -> account.withdraw(3000), "Withdrawal");
        BankAccount.runTest(() -> account.deposit(-500), "Deposit");
        BankAccount.runTest(() -> account.withdraw(20000), "Withdrawal");
        BankAccount.runTest(() -> account.deposit(60000), "Deposit");
    }

}
