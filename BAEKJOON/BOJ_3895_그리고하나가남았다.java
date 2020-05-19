// 2020_05_18_월_문풀_35회차_그리고 하나가 남았다

/*
 * 1. 마지막 남은 돌의 번호
 *
 * 2. 2≤n≤10000, 1≤k≤10000, 1≤m≤n
 *
 * 3. dp인줄 알았는데 그냥 조건 맞게 list 구현하면 되는 듯?
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3895_그리고하나가남았다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()) - 1;


            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            if(n == 0){
                return;
            }

            while (list.size() > 1) {
                list.remove(m);
                m += k;

                if (m >= list.size()) {
                    m %= list.size();
                }
            }

            if (list.size() > 0) {
                System.out.println(list.get(0));
            }

            list.clear();
        }
    }
}
