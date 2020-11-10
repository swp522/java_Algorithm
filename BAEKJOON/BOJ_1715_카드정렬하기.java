// 2020_11_10_화

/*

    1. 최소 비교 횟수 구하기

    2. 1 ≤ N ≤ 100,000

    3. 우선순위 큐로 구현

       넣는 순서에 상관없이 정수값 작은거 순서대로 poll 함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();
            answer += (first + second);
            pq.add(first + second);
        }

        System.out.println(answer);
    }
}
