// 2021_01_24_일

/*

    1. 라이언 인형(1)이 k개 이상 있는 가장 작은 연속 인형 집합 구하기

       없으면 -1 출력하기

    2. 1 ≤ K ≤ N ≤ 10^6

    3. 1). 라이언만 리스트 만들기

       2). 투포인터 로직 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15565_귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                lions.add(i);
            }
        }

        if (lions.size() < k) {
            System.out.println(-1);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int start = 0; start < lions.size(); start++) {
            int end = start;
            int count = 0;
            while (end < lions.size() && count < k) {
                count++;
                end++;
            }

            if (count == k) {
                int left = lions.get(start);
                int right = lions.get(end - 1);
                answer = Math.min(answer, right - left + 1);
            }
        }

        System.out.println(answer);
    }
}
