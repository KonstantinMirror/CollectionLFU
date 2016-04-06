package epamlab.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserString {

	private Map<String, Integer> words;

	public String getWordFrequency(String word) {
		String outMessage;
		word = word.toLowerCase();
		if (words.containsKey(word)) {
			outMessage = word + " Frequency  is " + words.get(word);
		} else {
			outMessage = "Word " + word + " is not contain";
		}

		return outMessage;
	}

	public Map<String, Integer> getAllWords(String string) {
		final String WORD_SPLITER = "\\w+";
		final int START_VALUE = 1;
		Pattern pattern = Pattern.compile(WORD_SPLITER);
		Matcher matcher = pattern.matcher(string);
		words = new HashMap<>();
		while (matcher.find()) {
			String currentWord = matcher.group().toLowerCase();
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
