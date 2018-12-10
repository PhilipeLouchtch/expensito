package louchtch.expensito.model;

import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

import java.util.Set;

public interface Expense
{
	Numeraire cost();
	Description description();
	TimeMoment happenedOn();

	interface Description
	{
		String text();
		Set<Tag> tags();
	}
}
