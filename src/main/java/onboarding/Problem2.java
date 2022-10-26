package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        while (!cryptogram.equals(distinct(cryptogram))) {
            cryptogram = distinct(cryptogram);
        }
        return cryptogram;
    }

    private static String distinct(String cryptogram) {
        for (int i = 0; i < 26; i++) {
            String alphabet = String.valueOf((char) ('a' + i));
            cryptogram = cryptogram.replaceAll(alphabet + "{2,}", "");
        }
        return cryptogram;
    }
}
