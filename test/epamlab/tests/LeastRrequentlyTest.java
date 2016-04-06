package epamlab.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import epamlab.util.LFUCache;

public class LeastRrequentlyTest {

	@Test
	public void testAdd () {
		LFUCache<String, Integer> cache = new LFUCache<>(4, 0.8);
		cache.put("hello", 1);
		cache.put("world", 2);
		cache.put("Earth", 3);
		cache.print();
		cache.get("Earth");
		cache.print();
		for (int i = 0; i < 10; i++) {
			cache.get("hello");
		}
		cache.print();
	}
	
	@Test
	public void TestClear(){
		LFUCache<String, Integer> cache = new LFUCache<>(4, 0.8);
		cache.put("hello", 1);
		cache.put("world", 2);
		cache.put("Earth", 3);
		cache.put("Pies", 3);
		cache.print();
		for (int i = 0; i < 10; i++) {
			cache.get("hello");
		}
		cache.print();
		cache.put("Zip", 3);
		cache.put("Rar", 3);
		cache.print();
	}

}
