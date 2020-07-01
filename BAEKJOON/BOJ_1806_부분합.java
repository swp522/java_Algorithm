// 2020_07_01_수_부분합

/*
 * 1. 부분합이 S 이상이 되는 가장 짧은 길이 구하기
 *
 * 2. 10 ≤ N < 100,000  , 0 < S ≤ 100,000,000
 *
 * 3. 투포인터로 구현 -> 시간 복잡도 O(2N)
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
        int rightPointer = 0;
        int leftPointer = 0;

        while (true) {
            if (sum >= s) {
                sum -= arr[leftPointer++];
                minLength = Math.min(minLength, (rightPointer - leftPointer) + 1);
            } else if (rightPointer == n) {
                break;
            } else {
                sum += arr[rightPointer++];
            }
        }

        if (minLength == 100001) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }

    }
}
