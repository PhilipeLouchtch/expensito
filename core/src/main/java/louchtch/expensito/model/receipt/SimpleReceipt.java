package louchtch.expensito.model.receipt;

import louchtch.money.Numeraire;
import louchtch.time.time.TimeMoment;

public class SimpleReceipt implements Receipt
{
	private ReceiptItems items;
	private Description description;
	private TimeMoment happenedOn;

	public SimpleReceipt(ReceiptItems items, Description description, TimeMoment happenedOn)
	{
		this.items = items;
		this.description = description;
		this.happenedOn = happenedOn;
	}

	@Override
	public Numeraire cost()
	{
		return items.sumTotal();
	}

	@Override
	public Description description()
	{
		return description;
	}

	@Override
	public TimeMoment happenedOn()
	{
		return happenedOn;
	}
}
