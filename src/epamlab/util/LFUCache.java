package epamlab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LFUCache<K, V> {

	private final int CACHE_SIZE;
	private final double EVICTION_FACTOR;

	private Map<K, Pair<V>> cache;
	private List<Set<K>> listRow;

	public Map<K, Pair<V>> getCache() {
		return cache;
	}

	public void setCache(Map<K, Pair<V>> cache) {
		this.cache = cache;
	}

	public List<Set<K>> getListRow() {
		return listRow;
	}

	public void setListRow(List<Set<K>> listRow) {
		this.listRow = listRow;
	}

	public LFUCache(int size, double evictionFactor) {
		CACHE_SIZE = size;
		EVICTION_FACTOR = evictionFactor;
		cache = new HashMap<>();
		listRow = new ArrayList<>(CACHE_SIZE);
		for (int i = CACHE_SIZE; i > 0; i--) {
			listRow.add(new LinkedHashSet<>());
		}
	}

	public void print() {
		for (Set<K> set : listRow) {
			System.out.println(set);
		}
		System.out.println("------------------------");

	}

	public void put(K k, V v) {
		if (cache.size() >= CACHE_SIZE) {
			evict();
		}
		if (!cache.containsKey(k)) {
			listRow.get(0).add(k);
			cache.put(k, new Pair<>(v, 0));
		}
	}

	public V get(K k) {
		if (cache.containsKey(k)) {
			Pair<V> pair = cache.get(k);
			int row = pair.getRow();
			if (row < CACHE_SIZE - 1) {
				listRow.get(pair.getRow()).remove(k);
				pair.setRow(row + 1);
				listRow.get(pair.getRow()).add(k);
			}
			return pair.getValue();
		} else {
			return null;
		}

	}

	private void evict() {
		int countEvict = (int) Math.round(CACHE_SIZE * EVICTION_FACTOR);
		for (Set<K> set : listRow) {
			Iterator<K> iterator = set.iterator();
			while (countEvict > 0 && iterator.hasNext()) {
				cache.remove(iterator.next());
				iterator.remove();
				countEvict--;
			}
		}
	}

	private class Pair<T> {
		private T t;
		private int row;

		public Pair() {
		}

		public Pair(T t, int row) {
			super();
			this.row = row;
			this.t = t;
		}

		public T getValue() {
			return t;
		}

		public void setValue(T t) {
			this.t = t;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		@Override
		public String toString() {
			return "Pair [t=" + t + ", row=" + row + "]";
		}

	}
}
