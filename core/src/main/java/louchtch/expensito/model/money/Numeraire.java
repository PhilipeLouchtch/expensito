package louchtch.expensito.model.money;

public interface Numeraire
{
	String asString();
	Numeraire add(Numeraire other);
	Numeraire substract(Numeraire other);
}
