package epamlab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCache<K, V> {

	private final int CACHE_SIZE;
	private final double EVICTION_FACTOR;

	private Map<K, V> map;
	private List<List<K>> listRow;
	private List<K> row;

	public LFUCache(int size, double evictionFactor) {
		super();
		CACHE_SIZE = size;
		EVICTION_FACTOR = evictionFactor;
		map = new HashMap<>();
		listRow = new ArrayList<>(CACHE_SIZE);
		for (int i = CACHE_SIZE; i > 0; i--) {
			listRow.add(new ArrayList<>(CACHE_SIZE));

		}
		row = new ArrayList<>();
	}

	public void put(K k, V v) {
		if (!map.containsKey(k)) {
			map.put(k, v);
			listRow.get(0).add(k);
		}
	}

	
	
	
	
	
	
	
	
	private class Pair {
		private long row;
		private long line;

		public Pair() {
		}

		public Pair(long row, long line) {
			super();
			this.row = row;
			this.line = line;
		}

		public long getRow() {
			return row;
		}

		public void setRow(long row) {
			this.row = row;
		}

		public long getLine() {
			return line;
		}

		public void setLine(long line) {
			this.line = line;
		}

	}

	public K get(K t) {
		if (map.containsKey(t)) {
			int countGet = map.get(t);
			map.put(t, countGet + 1);
			if (!(countGet > CACHE_SIZE)) {
				listRow.get(countGet - 1).remove(t);
				listRow.get(countGet).add(t);
			}
		}
		return t;// ?????
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
}
