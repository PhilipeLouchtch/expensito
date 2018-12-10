package louchtch.expensito.model;

import louchtch.util.SingletonObjectCache;

public class SimpleTag implements Tag
{
	private String label;

	private SimpleTag(String label)
	{
		this.label = label;
	}

	@Override
	public String label()
	{
		return label;
	}

	private static SingletonObjectCache<String, Tag> tags;
	public static Tag from(String label)
	{
		return tags.computeIfAbsent(label, SimpleTag::new);
	}
}
