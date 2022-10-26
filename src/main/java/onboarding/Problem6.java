package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        return new ArrayList<>(extractAnswerOfDuplicationWords(forms));
    }

    private static Set<String> extractAnswerOfDuplicationWords(List<List<String>> forms) {
        return composeWordsDictionary(forms)
            .stream()
            .filter(Problem6::isDuplication)
            .flatMap(Collection::stream)
            .collect(Collectors.toSet());
    }

    private static boolean isDuplication(List<String> emails) {
        return emails.size() >= 2;
    }

    private static Collection<List<String>> composeWordsDictionary(List<List<String>> forms) {
        Map<String, List<String>> wordsDictionary = new HashMap<>();
        for (List<String> form : forms) {
            addEmailsInNickname(wordsDictionary, form);
        }
        return wordsDictionary.values();
    }

    private static void addEmailsInNickname(Map<String, List<String>> wordsDictionary, List<String> form) {
        String nickname = form.get(NICKNAME_INDEX);
        for (int i = 0; i < nickname.length() - 1; i++) {
            String key = nickname.substring(i, i + 2);
            addEmails(wordsDictionary, key, form.get(EMAIL_INDEX));
        }
    }

    private static void addEmails(Map<String, List<String>> wordsDictionary, String key, String email) {
        if (wordsDictionary.containsKey(key)) {
            List<String> value = wordsDictionary.get(key);
            value.add(email);
            return;
        }
        wordsDictionary.put(key, new ArrayList<>(List.of(email)));
    }
}
