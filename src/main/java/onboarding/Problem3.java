package onboarding;

import java.util.List;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 2; i <= number; i++) {
            answer += countClapNumber(i);
        }
        return answer;
    }

    private static int countClapNumber(int number) {
        int answer = 0;
        while (number > 9) {
            if (isClapNumber(number % 10)) {
                answer += 1;
            }
            number /= 10;
        }
        if (isClapNumber(number)) {
            answer += 1;
        }
        return answer;
    }

    private static boolean isClapNumber(int number) {
        List<Integer> clapNumbers = List.of(3, 6, 9);
        return clapNumbers.stream()
            .anyMatch(it -> number == it);
    }


}
