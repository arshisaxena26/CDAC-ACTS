package customException;

@SuppressWarnings("serial")
public class CustomHandlingException extends Exception{
	public CustomHandlingException(String errorMsg) {
		super(errorMsg);
	}
}
