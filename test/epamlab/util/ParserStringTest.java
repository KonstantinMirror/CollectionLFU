package epamlab.util;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ParserStringTest {

	@Test
	public void test() {

		Map<String, Integer> words = ParserString.getAllWords("Hello World");
		assertTrue(words.size() == 2);
	}

}
