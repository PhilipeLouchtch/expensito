package louchtch.expensito.model;

import louchtch.util.SingletonObjectCache;

import java.lang.ref.WeakReference;
import java.util.Map;

public class Tag
{
	private String label;

	private Tag(String label)
	{
		this.label = label;
	}

	public String label()
	{
		return label;
	}

	private static SingletonObjectCache<String, Tag> tags;
	public static Tag from(String label)
	{
		return tags.computeIfAbsent(label, Tag::new);
	}
}
