package m4_Activity5;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== Account Number Validation Test ===\n");
		
		testValidation("Test 1: Valid account", "1234567890");
		testValidation("Test 2: Too short", "123");
		testValidation("Test 3: Contains letters", "12345ABC90");
		testValidation("Test 4: Contains space", "1234 567890");
		testValidation("Test 5: Null value", null);
		
	}
	
	public static void testValidation(String testName, String accountNumber) {
		
		System.out.println(testName + " (" + accountNumber +")");
		try {
			(new AccountValidator()).validateAccountNumber(accountNumber);
			
		}catch(InvalidAccountNumberException e) {
			System.out.println("Error: " + e.getMessage());

		}catch(InvalidAccountFormatException e) {
			System.out.println("Warning: " + e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println("Warning: " + e.getMessage());
		}
		System.out.println();
	}

}
