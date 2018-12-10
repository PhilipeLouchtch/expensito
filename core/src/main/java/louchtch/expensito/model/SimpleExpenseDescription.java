package louchtch.expensito.model;

import java.util.Collections;
import java.util.Set;

public class SimpleExpenseDescription implements Expense.Description
{
	private String text;
	private Set<Tag> tagSet;

	private SimpleExpenseDescription(String text, Set<Tag> tagSet)
	{
		this.text = text;
		this.tagSet = tagSet;
	}

	public String text()
	{
		return text;
	}

	public Set<Tag> tags()
	{
		return Collections.unmodifiableSet(tagSet);
	}

	public void attachTag(Tag tag)
	{
		tagSet.add(tag);
	}
}
