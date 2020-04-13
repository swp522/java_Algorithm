// 2020_04_13_월_과제_26회차_볼 모으기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615_볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        int rCount = 0;
        int bCount = 0;

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = input.charAt(i);
            if (arr[i] == 'R') {
                rCount++;
            } else {
                bCount++;
            }
        }

        if (bCount == n || rCount == n) {
            System.out.println(0);
        } else {
            solve(arr, n, rCount, bCount);
        }
    }


    public static void solve(char[] arr, int n, int rCount, int bCount) {
        // left에 R을 모으기
        int minAnswer = Integer.MAX_VALUE, targetCount = 0, index = 0;
        while (arr[index++] == 'R') {
            targetCount++;
        }
        minAnswer = Math.min(minAnswer, rCount - targetCount);

        //Right에 R를 모으기
        index = n - 1;
        targetCount = 0;
        while (arr[index--] == 'R') {
            targetCount++;
        }
        minAnswer = Math.min(minAnswer, rCount - targetCount);

        //Left에 B을 모으기
        index = 0;
        targetCount = 0;
        while (arr[index++] == 'B') {
            targetCount++;
        }
        minAnswer = Math.min(minAnswer, bCount - targetCount);

        //RIGHT에 B를 모으기
        index = n - 1;
        targetCount = 0;
        while (arr[index--] == 'B') {
            targetCount++;
        }
        minAnswer = Math.min(minAnswer, bCount - targetCount);

        System.out.println(minAnswer);
    }
}
