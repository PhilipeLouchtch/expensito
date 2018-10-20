package louchtch.expensito.model;

import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

public class Expense
{
	private Numeraire sum;
	private ExpenseDescription description;
	private TimeMoment expenseHappened;
	private TimeMoment expenseCreated;

	public Numeraire sum()
	{
		return sum;
	}

	public ExpenseDescription description()
	{
		return description;
	}
}
