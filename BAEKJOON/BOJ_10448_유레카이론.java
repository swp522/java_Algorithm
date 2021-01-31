// 2021_01_31_일

/*

    1. 주어진 자연수가 3개의 삼각수의 합으로 표현가능한지 구하기

    2. 3 ≤ K ≤ 1,000

    3. 미리 3개의 합으로 나타낼 수 있는지를 구해놓고 입력값 확인함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10448_유레카이론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[50];
        int temp = 2;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + temp;
            temp++;
        }

        boolean[] check = new boolean[1001];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    int num = arr[i] + arr[j] + arr[k];
                    if (num > 1000) {
                        continue;
                    }

                    check[num] = true;
                }
            }
        }

        for (int t = 0; t < testCase; t++) {
            int k = Integer.parseInt(br.readLine());
            if (check[k]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
