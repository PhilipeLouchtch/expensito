package louchtch.expensito.model;

import louchtch.expensito.model.money.Numeraire;
import louchtch.expensito.model.time.TimeMoment;

import java.util.Set;

public class CompositeExpense implements Expense
{
	private Set<Expense> expenses;
	private ExpenseDescription description;
	private final TimeMoment happenedOn;

	public CompositeExpense(Set<Expense> expenses, ExpenseDescription description, TimeMoment happenedOn)
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
	public ExpenseDescription description()
	{
		return description;
	}

	@Override
	public TimeMoment happenedOn()
	{
		return null;
	}
}
