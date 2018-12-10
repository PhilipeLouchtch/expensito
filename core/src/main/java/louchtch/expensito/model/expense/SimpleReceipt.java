package louchtch.expensito.model.expense;

import louchtch.expensito.model.Expense;
import louchtch.expensito.model.SimpleExpenseDescription;
import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

import java.util.Set;

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
