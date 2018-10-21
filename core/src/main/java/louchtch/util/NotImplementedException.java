package louchtch.util;

public class NotImplementedException extends RuntimeException
{
	private NotImplementedException(String message)
	{
		super(message);
	}

	public static NotImplementedException functionality(String functionality)
	{
		String message = String.format("The '%s' functionality is not implemented yet", functionality);
		return new NotImplementedException(message);
	}
}
