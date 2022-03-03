/*
1. 아이디어
- 동전을 저장한뒤, 반대로 뒤집음
- 동전을 for >
    - 동전 사용개수 추가
    - 동전 사용한 만큼 K값 갱신

2. 시간복잡도
 - O(N)

3. 자료구조
- 동전 금액 : int[]
- 동전 사용 count : int
- 남은 금액 : int

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i > 0; i--) {
            if(k >= coins[i]){
                count += k/coins[i];
                k = k % coins[i];
            }
        }

        System.out.print(count);
    }
}
