package louchtch.expensito.model.money;

public abstract class FiatMoney
{
	private int cents;

	protected FiatMoney(int cents)
	{
		this.cents = cents;
	}

	public int asCents()
	{
		return cents;
	}
}
