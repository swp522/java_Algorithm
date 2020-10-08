// 2020_10_08_목

/*
    1. 총 합의 최대값 구하기

    2. 1 ≤ N ≤ 100,000   /   1 ≤ M ≤ N   /   보석 가치 절대값 <= 2000

    3. 완전 탐색

       아직 구현중. 런타임 에러 발생
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2208_보석줍기 {

    static int n, m;
    static int[] treasures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        treasures = new int[n + 1];
        for (int i = 0; i < n; i++) {
            treasures[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int mainPointer = 0; mainPointer < n; mainPointer++) {

            if (mainPointer % m == 0) {

                int partMaxSum = Integer.MIN_VALUE;
                for (int i = 0; i < m; i++) {
                    int tempSum = 0;

                    for (int j = mainPointer + i; j < mainPointer + m; j++) {
                        tempSum += treasures[j];
                        partMaxSum = Math.max(partMaxSum, tempSum);
                    }

                }

                answer += partMaxSum;
            }
        }

        System.out.println(answer);
    }

}
