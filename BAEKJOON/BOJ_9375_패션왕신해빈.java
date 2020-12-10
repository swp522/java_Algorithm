// 2020_12_08_화

/*

    1. 옷 조합으로 가능한 경우의 수 다 구하기

    2. 0 ≤ n ≤ 3

    3. HashMap 으로 구현하고 마지막에 공식화해서 구하기

       공식이랑 마지막에 1개 빼주는거 생각하는데 좀 오래걸렸음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            HashMap<String, Integer> hm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (hm.containsKey(b)) {
                    hm.put(b, hm.get(b) + 1);
                } else {
                    hm.put(b, 1);
                }
            }

            int answer = 1;
            
            for (String key : hm.keySet()) {
                answer *= (hm.get(key) + 1);
            }

            System.out.println(answer - 1);
        }
    }
}
