package epamlab.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LFUCache<T> {

	private final int CACHE_SIZE;
	private final double EVICTION_FACTOR;

	private Map<T, Integer> map;
	private List<List<Map<T, Integer>>> listRow;
	List<Entry<T, Integer>> rowData;
	List<Map<T, Integer>> row;

	public LFUCache(int size, double ecictionFactor) {
		super();
		CACHE_SIZE = size;
		EVICTION_FACTOR = ecictionFactor;
		map = new HashMap<>();
		listRow = new ArrayList<>();
		rowData = new ArrayList<>();
		row = new ArrayList<>();
	}

	public void add(T t) {
		if (!map.containsKey(t)) {
			

		}

	}

}
