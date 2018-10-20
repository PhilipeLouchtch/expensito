package louchtch.expensito.model;

import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

public interface Expense
{
	Numeraire cost();
	ExpenseDescription description();
	TimeMoment happenedOn();
}
