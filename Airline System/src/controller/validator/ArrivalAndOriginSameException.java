package controller.validator;

public class ArrivalAndOriginSameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ArrivalAndOriginSameException(String field, String field2)
	{
		super(field + " and " + field2 + " location cannot be same.");
	}

}
