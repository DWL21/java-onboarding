package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<String, String> flogKeys = flogKeys();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            result.add(flogKeys.get(String.valueOf(word.charAt(i))));
        }
        return String.join("", result);
    }

    private static Map<String, String> flogKeys() {
        Map<String, String> words = new HashMap<>();
        List<String> passwords = List.of("Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J",
            "I", "H", "G", "F", "E", "D", "C", "B", "A");
        for (int i = 0; i < 26; i++) {
            String alphabet = String.valueOf((char) ('a' + i));
            words.put(alphabet, passwords.get(i).toLowerCase(Locale.ROOT));
        }
        for (int i = 0; i < 26; i++) {
            String alphabet = String.valueOf((char) ('A' + i));
            words.put(alphabet, passwords.get(i));
        }
        words.put(" ", " ");
        return words;
    }
}
