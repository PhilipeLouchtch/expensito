package louchtch.expensito.model.money;

import net.coolicer.assertion.Assert;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Euro implements Numeraire
{
	private final int cents;

	private Euro(int cents)
	{
		this.cents = cents;
	}

	@Override
	public String asString()
	{
		return null;
	}

	@Override
	public Numeraire add(Numeraire other)
	{
		return null;
	}

	@Override
	public Numeraire substract(Numeraire other)
	{
		return null;
	}

	@Override
	public Numeraire asNegative()
	{
		return new Euro(0 - cents);
	}

	private static Pattern euroPattern = Pattern.compile("^€?[ ]*(\\d+([,.]\\d+)?)[ ]*$");
	public static Euro parseFrom(String string) throws EuroParseException
	{
		Matcher matcher = euroPattern.matcher(string);
		if (!matcher.find()) {
			throw EuroParseException.dueToNotMatchingPattern(string);
		}

		String match = matcher.group(1);
		String[] split = match.split(",.");
		Assert.that(split.length <= 2).orThrow(EuroParseException::dueToErrorDuringMatching);

		Integer fullEuros = Integer.parseInt(split[0]);
		Integer cents = 0;
		if (split.length == 2)
		{
			String centsUnparsed = split[1];
			switch (centsUnparsed.length())
			{
				case 0:
					cents = 0;
					break;
				case 1:
					cents = Integer.parseInt(centsUnparsed) * 10;
					break;
				case 2:
					cents = Integer.parseInt(centsUnparsed);
					break;
				default:
					cents = Integer.parseInt(centsUnparsed.substring(0, 2));
			}
		}

		return new Euro(fullEuros * 100 + cents);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Euro euro = (Euro) o;
		return cents == euro.cents;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash('€', cents);
	}
}
