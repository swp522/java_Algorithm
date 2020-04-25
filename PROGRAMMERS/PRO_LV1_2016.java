//2020_04_25_토_PROGRAMMERS_KAKAO_LV1_2016

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRO_LV1_2016 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int date = 0;
        for (int i = 0; i < (a - 1); i++) {
            date += month[i];
        }
        date += (b - 1);
        date %= 7;

        answer = days[date];

        return answer;
    }
}
