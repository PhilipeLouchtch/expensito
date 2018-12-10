package louchtch.money;

public interface Numeraire
{
	String asString();
	Numeraire add(Numeraire other);
	Numeraire substract(Numeraire other);
	Numeraire asNegative();

	Numeraire identity = new NumeraireIdentity();
}
