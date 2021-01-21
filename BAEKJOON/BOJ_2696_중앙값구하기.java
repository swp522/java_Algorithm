// 2021_01_21_목

/*

    1. 첫째줄 : 중앙값 개수, 둘쨰줄 : 홀수번째 읽을 때마다 구한 중앙값들

    2. 1 <= T <= 1,000   /   1 <= M <= 9999, M = 홀수

    3. 1). 중앙값 개수는 (n + 1) / 2 로 구하기

       2). 값 입력 받을 때마다 sort 하고, 짝수 index 접근시마다 (i / 2) 번째 값 출력

       3). end == 9 이면 개행 처리

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2696_중앙값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(((n + 1) / 2) + "\n");
            ArrayList<Integer> list = new ArrayList<>();

            int end = 0;
            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                Collections.sort(list);

                if (i % 2 == 0) {
                    if (end == 9 || i == n - 1) {
                        sb.append(list.get(i / 2) + "\n");
                    } else {
                        sb.append(list.get(i / 2) + " ");
                    }

                    end++;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
