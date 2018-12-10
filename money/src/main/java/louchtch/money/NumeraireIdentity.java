package louchtch.money;

class NumeraireIdentity implements Numeraire
{
	NumeraireIdentity()
	{
	}

	@Override
	public String asString()
	{
		return "0";
	}

	@Override
	public Numeraire add(Numeraire other)
	{
		return other;
	}

	@Override
	public Numeraire substract(Numeraire other)
	{
		return other.asNegative();
	}

	@Override
	public Numeraire asNegative()
	{
		return this;
	}
}
