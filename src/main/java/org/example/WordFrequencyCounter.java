package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String[] words = text.toLowerCase().split(Pattern.quote(" "));
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public static <K, V> Map<V, K> reverseMap(Map<K, V> originalMap) {
        Map<V, K> reversedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        return reversedMap;
    }
}
