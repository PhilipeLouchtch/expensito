package louchtch.expensito.model;

import louchtch.money.Numeraire;
import louchtch.time.TimeMoment;

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
