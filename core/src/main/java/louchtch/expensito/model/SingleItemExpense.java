package louchtch.expensito.model;

import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

public class SingleItemExpense implements Expense
{
	private Numeraire cost;
	private ExpenseDescription description;

	private TimeMoment happenedOn;

	public Numeraire cost()
	{
		return cost;
	}

	public ExpenseDescription description()
	{
		return description;
	}

	public TimeMoment happenedOn()
	{
		return happenedOn;
	}
}
