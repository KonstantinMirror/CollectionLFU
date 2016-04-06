package epamlab.tests;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import epamlab.util.ParserString;

public class ParserStringTest {

	@Test
	public void test() {
		ParserString parserString = new ParserString();
		Map<String, Integer> words = parserString.getAllWords("Hello World");
		assertTrue(words.size() == 2);
		System.out.println(parserString.getWordFrequency("hello"));
		System.out.println(parserString.getWordFrequency("Hello"));
		System.out.println(parserString.getWordFrequency("zip"));
		words = parserString.getAllWords("WORLD world Hello_world HelloWorld ");
		assertTrue(words.get("world") == 2);
	}

}
