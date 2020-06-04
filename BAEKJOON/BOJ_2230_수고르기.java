// 2020_06_05_금_38회차_과제2_수 고르기
// 국은 코테라 불참

/*
 * 1. 주어진 수열에서 차이가 M 이상인 가장 큰 차이값 구하기
 *
 * 2. 1≤N≤100,000  ,0 ≤ N ≤ 2,000,000,000  ,0 ≤ |A[i]| ≤ 1,000,000,000
 *
 * 3. 구현인데 백퍼 시간초과 나올 듯
 *
 *    같은 두 수를 고를 수도 있음 !
 *
 *    차이가 m 이상이면 left++ 이하면 right++
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while(left < n && right < n){
            int value = arr[right] - arr[left];

            if(value >= m){
                min = Math.min(min, value);
                left++;
            } else{
                right++;
            }
        }

        System.out.println(min);
    }
}
