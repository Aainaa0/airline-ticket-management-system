package controller.validator;

public class RequiredRadioButton extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RequiredRadioButton(String field)
	{
		super(field + " is required.");
	}

	
}