// 2020_09_25_금_부분합

/*
 * 1. 부분합이 S 이상이 되는 가장 짧은 길이 구하기
 *
 * 2. 10 ≤ N < 100,000  , 0 < S ≤ 100,000,000
 *
 * 3. 투포인터로
 *
 *    1). first, second 포인터 이동하면서 min 값 구하기
 *
 *    2).길이가 100000 이상이면 최소 길이 구하는게 불가능함
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = 100001;
        int sum = 0;
        int first = 0;
        int second = 0;

        while (true) {
            if (sum >= s) {
                sum -= arr[second++];
                minLength = Math.min(minLength, (first - second) + 1);
            } else if (first == n) {
                break;
            } else {
                sum += arr[first++];
            }
        }

        if (minLength > 100000){
            System.out.println(0);
        } else{
            System.out.println(minLength);
        }

    }

}
