package m4_Activity9.exception;

public class InvalidTransferException extends Exception {
	
    public InvalidTransferException(String message) {
        super(message);
    }
    
    public InvalidTransferException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
