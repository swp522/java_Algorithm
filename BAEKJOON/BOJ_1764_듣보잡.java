// 2020_10_12_월

/*

    1. n개 m개 문자열 중에서 겹치는거 갯수, 문자열 출력하기

    2. N, M은 500,000 이하의 자연수

    3. HashMap 활용

    4. 오름차순 해줘야하는거 못봤음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(br.readLine(), 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (hm.containsKey(input)) {
                list.add(input);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
