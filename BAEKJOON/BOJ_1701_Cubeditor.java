// 2020_05_08_금_과제_34회차_Cubeditor

/*
 * 1. 두 번이상 나오는 부분문자열 중에서 가장 긴 것 출력하기
 *
 * 2. 문자열 길이 <= 5000
 *
 * 3. 문자열, 구현, KMP 알고리즘(접두사, 접미사 일치하는 최대 길이)
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1701_Cubeditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int answer = 0, temp = 0;

        for (int i = 0; i < len; i++) {
            temp = KMP(input.substring(i, len));    // 문자열 시작위치 바꿔가면서 KMP 적용
            if (temp > answer) {
                answer = temp;
            }
        }

        System.out.println(answer);
    }


    public static int KMP(String str) {
        int len = str.length();
        int[] arr = new int[len];
        arr[0] = 0;
        int j = 0;
        int max = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = arr[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                arr[i] = ++j;
                if (max < arr[i]) {
                    max = arr[i];
                }
            } else {
                arr[i] = 0;
            }
        }

        return max;
    }

}