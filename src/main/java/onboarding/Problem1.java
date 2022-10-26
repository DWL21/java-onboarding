package onboarding;

import java.util.List;

class Problem1 {

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    private static final int PAGE_STARTING = 1;
    private static final int PAGE_FINISHING = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isExceptionSituation(pobi) || isExceptionSituation(crong)) {
            return -1;
        }
        return whoIsWinner(maxValue(pobi), maxValue(crong));
    }

    private static boolean isExceptionSituation(List<Integer> people) {
        int left = people.get(LEFT_PAGE_INDEX);
        int right = people.get(RIGHT_PAGE_INDEX);
        return  left % 2 == 0 || (right - left != 1) || left <= PAGE_STARTING || right >= PAGE_FINISHING;
    }

    private static int maxValue(List<Integer> people) {
        int left = people.get(LEFT_PAGE_INDEX);
        int right = people.get(RIGHT_PAGE_INDEX);
        return Integer.max(sumDigits(left) + sumDigits(right), multiplyDigits(left) * multiplyDigits(right));
    }

    private static int sumDigits(int number) {
        int answer = 0;
        while(number > 0) {
            answer += number % 10;
            number /= 10;
        }
        return answer;
    }

    private static int multiplyDigits(int number) {
        int answer = 1;
        while(number > 0) {
            answer *= number % 10;
            number /= 10;
        }
        return answer;
    }

    private static int whoIsWinner(int a, int b) {
        if (a > b) {
            return 1;
        }
        if (a < b) {
            return 2;
        }
        return 0;
    }
}
