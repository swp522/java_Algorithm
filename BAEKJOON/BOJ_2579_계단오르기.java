//2020_03_27_과제_21회차_계단오르기
//DP로 접근해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]  stairs = new int[300];
        int[]  maxValue = new int[300];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        maxValue[0] = stairs[0];
        maxValue[1] = stairs[0] + stairs[1];
        maxValue[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for(int i = 3; i<n;i++){
            maxValue[i] = Math.max(maxValue[i-2] + stairs[i], maxValue[i-3] +stairs[i-1] + stairs[i]);
        }
        //맨 마지막 계단 기준으로 2가지 경우를 고려
        System.out.println(maxValue[n-1]);
    }
}