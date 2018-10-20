package louchtch.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SingletonObjectCache<K, V>
{
	private Map<K, WeakReference<V>> cache;

	private SingletonObjectCache(Map<K, WeakReference<V>> cache)
	{
		this.cache = cache;
	}

	public V computeIfAbsent(K key, Function<K, V> computeFunction)
	{
		//TODO: is there a race condition here between GC and WeakReference#get ??

		Function<K, WeakReference<V>> weakReferenceComputeFunction = (K k) -> new WeakReference<>(computeFunction.apply(k));
		WeakReference<V> weaklyReferencedValue = cache.computeIfAbsent(key, weakReferenceComputeFunction);

		return weaklyReferencedValue.get();
	}

	public static <K, V> SingletonObjectCache<K, V> freshInstance()
	{
		HashMap<K, WeakReference<V>> map = new HashMap<>();
		return new SingletonObjectCache<>(map);
	}
}
