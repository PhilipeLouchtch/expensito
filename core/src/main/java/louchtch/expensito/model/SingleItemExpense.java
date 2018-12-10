package louchtch.expensito.model;

import louchtch.money.Numeraire;
import louchtch.time.time.TimeMoment;

public class SingleItemExpense implements Expense
{
	private Numeraire cost;
	private SimpleExpenseDescription description;

	private TimeMoment happenedOn;

	public Numeraire cost()
	{
		return cost;
	}

	public SimpleExpenseDescription description()
	{
		return description;
	}

	public TimeMoment happenedOn()
	{
		return happenedOn;
	}
}
