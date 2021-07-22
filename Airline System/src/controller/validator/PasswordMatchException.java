package controller.validator;

public class PasswordMatchException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PasswordMatchException(String field)
	{
		super("Password does not match");
	}

}
