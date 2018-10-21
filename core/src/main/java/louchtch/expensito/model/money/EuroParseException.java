package louchtch.expensito.model.money;

class EuroParseException extends Exception
{
	private EuroParseException(String message)
	{
		super(message);
	}

	static EuroParseException dueToNotMatchingPattern(String inputString)
	{
		return new EuroParseException(
				String.format("Couldn't parse [%s] into Euro, does not match pattern", inputString)
		);
	}

	static EuroParseException dueToErrorDuringMatching()
	{
		// TODO: improve
		return new EuroParseException("There was an error during parsing the string value");
	}
}
