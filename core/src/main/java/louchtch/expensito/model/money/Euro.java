package louchtch.expensito.model.money;

import louchtch.util.NotImplementedException;
import net.coolicer.assertion.Assert;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Euro implements Numeraire
{
	private final static EuroSign euroSign = new EuroSign();
	private final Integer cents;

	private Euro(int cents)
	{
		this.cents = cents;
	}

	@Override
	public String asString()
	{
		String euros;
		String centsOnly;

		String allCentsAsString = cents.toString();
		int length = allCentsAsString.length();
		switch (length)
		{
			case 0:
				euros = "0";
				centsOnly = "0";
				break;
			case 1:
			case 2:
				euros = "0";
				centsOnly = allCentsAsString;
				break;
			default:
				euros = String.valueOf(this.cents / 100);
				centsOnly = allCentsAsString.substring(length-2, length);
				break;
		}

		return euroSign.asChar()
				+ euros
				+ ","
				+ centsOnly;
	}

	@Override
	public Numeraire add(Numeraire other)
	{
		// TODO: do conversion between numeraires
		if (other instanceof Euro) {
			return new Euro(this.cents + ((Euro) other).cents);
		}

		throw NotImplementedException.functionality("conversion between numeraires");
	}

	@Override
	public Numeraire substract(Numeraire other)
	{
		return this.add(other.asNegative());
	}

	@Override
	public Numeraire asNegative()
	{
		return new Euro(0 - cents);
	}

	// TODO: extract into some kind of 2-decimal-fiat shared implementation
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
					break;
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
		return cents.equals(euro.cents);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(euroSign.asChar(), cents);
	}

	private final static class EuroSign
	{
		final static char sign = '€';

		public char asChar()
		{
			return sign;
		}
	}
}
