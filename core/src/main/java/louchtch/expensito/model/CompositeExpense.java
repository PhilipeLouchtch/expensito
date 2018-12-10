package louchtch.expensito.model;

import louchtch.money.Numeraire;
import louchtch.time.time.TimeMoment;

import java.util.Set;

public class CompositeExpense implements Expense
{
	private Set<Expense> expenses;
	private SimpleExpenseDescription description;
	private final TimeMoment happenedOn;

	public CompositeExpense(Set<Expense> expenses, SimpleExpenseDescription description, TimeMoment happenedOn)
	{
		this.expenses = expenses;
		this.description = description;
		this.happenedOn = happenedOn;
	}

	@Override
	public Numeraire cost()
	{
		Numeraire sumTotal = expenses.stream()
				.map(Expense::cost)
				.reduce(Numeraire.identity, Numeraire::add);

		return sumTotal;
	}

	@Override
	public SimpleExpenseDescription description()
	{
		return description;
	}

	@Override
	public TimeMoment happenedOn()
	{
		return null;
	}
}
