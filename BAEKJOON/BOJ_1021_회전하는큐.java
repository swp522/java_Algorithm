// 2020_12_21_월
// version 1.0

/*

    1. 2, 3번 연산돌린 횟수 최솟값 구하기

    2. n <= 50,  m <= n

    3. 문제 이해가 좀 오래걸렸는데, 덱 활용해서 구현하면 된다

       index 에 따라서 조건 나눠주는거 구현이 오래걸림

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int index = 0;
                Iterator<Integer> iterator = dq.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() == num) {
                        break;
                    }

                    index++;
                }

                if (index == 0) {
                    dq.pollFirst();
                    break;
                } else if (index > dq.size() / 2) {
                    dq.addFirst(dq.removeLast());
                    count++;
                } else {
                    dq.addLast(dq.removeFirst());
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}
