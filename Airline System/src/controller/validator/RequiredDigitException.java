package controller.validator;

public class RequiredDigitException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RequiredDigitException(String field, int digit)
	{
		super(field + " must be " + digit + " digit.");
	}
	
}

