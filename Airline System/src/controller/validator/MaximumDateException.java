package controller.validator;

public class MaximumDateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MaximumDateException(String field)
	{
		super(field + " cannot be larger than today.");
	}

}
