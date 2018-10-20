package louchtch.expensito.model.money;

public class EuroParseException extends Exception
{
	private EuroParseException(String message)
	{
		super(message);
	}

	public static EuroParseException dueToNotMatchingPattern(String inputString)
	{
		return new EuroParseException(
				String.format("Could parse [%s] into Euro, does not match pattern", inputString)
		);
	}

	public static EuroParseException dueToErrorDuringMatching()
	{
		// TODO: improve
		return new EuroParseException("There was an error during parsing the string value");
	}
}
