package m4_Activity9.exception;

public class InvalidAccountException extends Exception {
	
    public InvalidAccountException(String message) {
        super(message);
    }
    
    public InvalidAccountException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
