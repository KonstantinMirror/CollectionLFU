package epamlab.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserString {

	public static Map<String, Integer> getAllWords(String string) {
		final String WORD_SPLITER = "\\w+";
		final int START_VALUE = 0;
		Pattern pattern = Pattern.compile(WORD_SPLITER);
		Matcher matcher = pattern.matcher(string);
		Map<String, Integer> words = new HashMap<>();
		while (matcher.find()) {
			String currentWord = matcher.group();
			if (words.containsKey(currentWord)) {
				int currentValue = words.get(currentWord);
				words.put(currentWord, ++currentValue);
			} else {
				words.put(currentWord, START_VALUE);
			}
		}
		System.out.println(words);
		return words;
	}
}
