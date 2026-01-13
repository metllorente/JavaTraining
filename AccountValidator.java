package m4_Activity5;

public class AccountValidator {

	// Validate account number
	public void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException{
		
		if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null.");
        }

		// Checking if account number contains only digits
        for (char c : accountNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidAccountFormatException("Account number must contain only digits.");
            }
        }

     // Checking if account number contains only 10 digits
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits.");
        }

        System.out.println("Valid account number: " + accountNumber);

	}

}