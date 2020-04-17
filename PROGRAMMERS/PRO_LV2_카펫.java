//2020_04_17_금_PROGRAMMERS_LV2_카펫

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRO_LV2_카펫 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int brown = 10;
        int red = 2;
        solution(brown, red);
    }


    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for (int i = 1; i <= 5000; i++) {
            for (int j = 1; j <= 4000; j++) {
                if (brown + red == i * j) {
                    if (brown == (i * 2) + (j - 2) * 2) {
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }

            }
        }
        return answer;
    }
}
