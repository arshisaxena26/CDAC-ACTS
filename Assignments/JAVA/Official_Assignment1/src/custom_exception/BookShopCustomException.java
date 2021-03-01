package custom_exception;

@SuppressWarnings("serial")
public class BookShopCustomException extends Exception {
	public BookShopCustomException(String mesg) {
		super(mesg);
	}
}
