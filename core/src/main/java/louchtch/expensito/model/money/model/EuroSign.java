package louchtch.expensito.model.money.model;

public class EuroSign implements NumeraireSign
{
	final static String sign = "€";

	public String asString()
	{
		return sign;
	}
}
