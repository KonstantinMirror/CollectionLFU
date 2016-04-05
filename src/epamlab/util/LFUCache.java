package epamlab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LFUCache<K, V> {

	private final int CACHE_SIZE;
	private final double EVICTION_FACTOR;

	private Map<K, Pair<V>> map;
	private List<Set<K>> listRow;

	public LFUCache(int size, double evictionFactor) {
		super();
		CACHE_SIZE = size;
		EVICTION_FACTOR = evictionFactor;
		map = new HashMap<>();
		listRow = new ArrayList<>(CACHE_SIZE);
		for (int i = CACHE_SIZE; i > 0; i--) {
			listRow.add(new LinkedHashSet<>());
		}
	}

	public void put(K k, V v) {
		if (!map.containsKey(k)) {
			listRow.get(0).add(k);			
			map.put(k, new Pair<>(v, 0));
		}
	}

	

	public K get(K k) {
		if (map.containsKey(k)) {
			Pair<V> value = map.get(k);
			
			map.put(k, countGet + 1);
			if (!(countGet > CACHE_SIZE)) {
				listRow.get(countGet - 1).remove(k);
				listRow.get(countGet).add(k);
			}
		}
		return k;// ?????
	}

	private void evict() {
		long evictElements = Math.round(EVICTION_FACTOR * CACHE_SIZE);
		for (List<K> listDate : listRow) {
			if (!listDate.isEmpty()) {
				Iterator<K> iterator = listDate.iterator();
				while (iterator.hasNext()) {
					K t = iterator.next();
					map.remove(t);
					iterator.remove();
					evictElements--;
					if (evictElements == 0) {

					}
				}
			}
		}
	}
	
	
	
	
	
	private class Pair<T> {
		private T t;
		private long row;

		public Pair() {
		}

		public Pair(T t, long row) {
			super();
			this.row = row;
			this.t = t;
		}

		public T getK() {
			return t;
		}

		public void setK(T t) {
			this.t = t;
		}

		public long getRow() {
			return row;
		}

		public void setRow(long row) {
			this.row = row;
		}

	}
}
