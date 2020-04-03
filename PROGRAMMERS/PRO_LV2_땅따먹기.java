//2020_04_03_금_문풀_23회차_땅따먹기
//DP

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PRO_LV2_땅따먹기 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {

        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < land.length; i++) {
            Arrays.sort(land[i]);
        }
        answer = land[land.length - 1][3];

        return answer;
    }
}
