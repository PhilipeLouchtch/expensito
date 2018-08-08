package louchtch.expensito.model;

import louchtch.expensito.model.money.FiatMoney;
import louchtch.expensito.model.time.TimeMoment;

public class Expense
{
	private FiatMoney sum;
	private ExpenseDescription description;
	private TimeMoment expenseHappened;
	private TimeMoment expenseCreated;

	public FiatMoney sum()
	{
		return sum;
	}

	public ExpenseDescription description()
	{
		return description;
	}
}
