package epamlab.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import epamlab.util.LFUCache;

public class LeastRrequentlyTest {

	@Test
	public void testAdd() {
		LFUCache<String, Integer> cache = new LFUCache<>(4, 0.8);
		cache.put("hello", 1);
		cache.put("world", 2);
		cache.put("Earth", 3);
		assertTrue(cache.getCache().size() == 3);
		cache.print();
		cache.get("Earth");
		cache.print();
		for (int i = 0; i < 10; i++) {
			cache.get("hello");
			cache.get("world");
		}
		cache.print();
		cache.get("hello");
		cache.print();
		cache.put("Zip", 3);
		cache.print();
		assertTrue(cache.getCache().size() == 4);
		cache.print();
		cache.put("Rar", 3);
		assertTrue(cache.getCache().size() == 2);
		cache.print();
	}

}
