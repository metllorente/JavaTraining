package m4_Activity9;

import m4_Activity9.service.BankAccountService;
import m4_Activity9.util.TestOperation;

public class BankAccountServiceTest {

	private static int testNumber = 0;
	private static BankAccountService service = new BankAccountService();

	public static void main(String[] args) {
		
		System.out.println("========================================");
		System.out.println("BANK ACCOUNT SERVICE - TEST SCENARIOS");
		System.out.println("========================================\n");

		// Happy Path
		testCase(() -> service.createAccount("ACC001", "John Doe", 10000.0), "Create account ACC001 with initial balance 10000");
		testCase(() -> service.createAccount("ACC002", "Jane Smith", 5000.0), "Create account ACC002 with initial balance 5000");
		testCase(() -> service.transfer("ACC001", "ACC002", 3000.0), "Transfer 3000 from ACC001 to ACC002");

		// Error Cases
		testCase(() -> service.transfer("ACC001", "ACC999", 1000.0), "Transfer to non-existent account ACC999");
		testCase(() -> service.transfer("ACC001", "ACC002", -500.0), "Transfer with negative amount");
		testCase(() -> service.transfer("ACC001", "ACC001", 1000.0), "Transfer to same account");
		testCase(() -> service.transfer("ACC999", "ACC002", 1000.0), "Transfer from non-existent account");
		testCase(() -> service.transfer("ACC002", "ACC001", 50000.0), "Transfer with insufficient funds");
		testCase(() -> service.createAccount("ACC001", "Bob Johnson", 8000.0), "Create duplicate account ACC001");
		testCase(() -> service.createAccount(null, "Alice Brown", 5000.0), "Create account with null account number");
		testCase(() -> service.createAccount("ACC003", "", 5000.0), "Create account with empty owner name");
		testCase(() -> service.createAccount("ACC004", "Charlie Wilson", -1000.0), "Create account with negative balance");

		System.out.println("\n========================================");
		System.out.println("ALL TEST CASES COMPLETED!");
		System.out.println("Check your logs to see the results.");
		System.out.println("========================================");
		
	} // end of main method

	private static void testCase(TestOperation operation, String description) {

		testNumber++;
		System.out.println("--- Test Case " + testNumber + " ---");
		System.out.println("Description: " + description);

		try {

			operation.execute();
			System.out.println("Result: SUCCESS\n");

		} catch (Exception e) {
			System.out.println("Result: EXCEPTION - " + e.getMessage() + "\n");
		}

	} // end of testCase method


} // end of BankAccountServiceTest class
