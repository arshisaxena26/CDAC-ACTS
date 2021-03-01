package custom_exception;

@SuppressWarnings("serial")
public class CustomHandlingException extends Exception{
	public CustomHandlingException(String errorMsg) {
		super(errorMsg);
	}
}
