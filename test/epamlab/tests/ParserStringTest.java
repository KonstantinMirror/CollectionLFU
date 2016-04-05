package epamlab.tests;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import epamlab.util.ParserString;

public class ParserStringTest {
	
	

	@Test
	public void test() {

		Map<String, Integer> words = ParserString.getAllWords("Hello World");
		assertTrue(words.size() == 2);

		words = ParserString.getAllWords("WORLD world Hello_world HelloWorld ");
		assertTrue(words.get("world") == 2);
	}

}
