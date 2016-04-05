package epamlab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LFUCache<T> {

	private final int CACHE_SIZE;
	private final double EVICTION_FACTOR;
	private final int START_VALUE = 0;

	private Map<T, Integer> map;
	private List<List<T>> listRow;
	private List<T> row;

	public LFUCache(int size, double ecictionFactor) {
		super();
		CACHE_SIZE = size;
		EVICTION_FACTOR = ecictionFactor;
		map = new HashMap<>();
		listRow = new ArrayList<>();
		for (int i = CACHE_SIZE; i > 0; i--) {
			listRow.add(new ArrayList<>());

		}
		row = new ArrayList<>();
	}

	public void put(T t) {

		if (!map.containsKey(t)) {
			listRow.get(0).add(t);
		}
	}

	public T get(T t) {
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
		for (List<T> listDate : listRow ) {
			
			if(!listDate.isEmpty()){
				Iterator<T> iterator = listDate.iterator();
				while (iterator.hasNext()) {
					T t = iterator.next();
					map.remove(t);
					iterator.remove();
					evictElements--;
					if(evictElements == 0){
						
					}
				}
 			}
		}
	}
}
