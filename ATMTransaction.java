package m4_Activity3;

public class ATMTransaction {

    public static void checkBalance(String accountNumber, double balance) {
        System.out.println("\nProcessing balance inquiry...");

        try {
            int accountNumberInt = Integer.parseInt(accountNumber);

            // Determine account type based on first character
            char accountTypeValue = accountNumber.charAt(0);
            String accountType;
            if (accountTypeValue == '1') {
                accountType = "Savings";
            } else if (accountTypeValue == '2') {
                accountType = "Checking";
            } else {
                accountType = "Unknown";
            }

            // Print account details
            System.out.println("Account Type: " + accountType);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: P" + balance);
            System.out.println("Balance inquiry successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account number is empty or invalid!");
        } finally {
        	
            // Print receipt
            System.out.println("\n========= RECEIPT =========");
            System.out.println("Transaction Date: January 7, 2026");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("===========================\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM BALANCE INQUIRY SYSTEM ===");

        // Test Case 1: Valid Savings Account
        System.out.println("\n--- Test Case 1: Valid Savings Account ---");
        checkBalance("100123456", 15000.00);

        // Test Case 2: Valid Checking Account
        System.out.println("\n--- Test Case 2: Valid Checking Account ---");
        checkBalance("200987654", 25000.00);

        // Test Case 3: Invalid Account Number Format
        System.out.println("\n--- Test Case 3: Invalid Account Number Format ---");
        checkBalance("ABC12345", 15000.00);

        // Test Case 4: Empty Account Number
        System.out.println("\n--- Test Case 4: Empty Account Number ---");
        checkBalance("", 15000.00);

        System.out.println("=== All tests completed! ===");
    }

}
