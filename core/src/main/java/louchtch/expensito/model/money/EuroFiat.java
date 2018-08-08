package louchtch.expensito.model.money;

import louchtch.expensito.louchtch.util.SingletonObjectCache;

public class EuroFiat extends FiatMoney
{
	private EuroFiat(int cents)
	{
		super(cents);
	}

	private static SingletonObjectCache<Integer, EuroFiat> euroFiatCache = SingletonObjectCache.freshInstance();
	public FiatMoney fromCents(int cents)
	{
		return euroFiatCache.computeIfAbsent(cents, EuroFiat::new);
	}
}
