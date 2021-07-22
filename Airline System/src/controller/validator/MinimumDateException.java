package controller.validator;

public class MinimumDateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MinimumDateException(String field)
	{
		super(field + " cannot be before than today.");
	}

}
