package m4_Activity4;

public class AccountValidator {
	
	// Validate account number
    public static void validateAccountNumber(String accountNumber) throws Exception {
        if (accountNumber == null) {
            throw new NullPointerException("Cannot be null");
        }
        if (accountNumber.length() != 10) {
            throw new Exception("Must be 10 digits");
        }
        System.out.println("Valid account: " + accountNumber);
    }

    public static void main(String[] args) {
        
    	// Test cases
        String[] testCases = {"1234567890", "123", null};

        for (String account : testCases) {
            try {
                validateAccountNumber(account);
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
