// 2021_01_17_일

/*

    1. 비밀번호 찾기

    2. 1 ≤ N ≤ 100,000   /   1 ≤ M ≤ 100,000

    3. HasmMap 으로 받아서 key 있으면 출력해주기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            hm.put(first, second);
        }

        String target;
        for(int i = 0; i < m; i++){
            target = br.readLine();

            if(hm.containsKey(target)){
                System.out.println(hm.get(target));
            }
        }
    }
}
