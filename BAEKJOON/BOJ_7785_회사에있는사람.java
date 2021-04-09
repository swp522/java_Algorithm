// 2021_04_09_금

/*

    1. 회사에 있는 사람들 이름 역순으로 출력하기

    2. 2 ≤ n ≤ 106

    3. HashSet 으로 출입 관리하고 마지막에 배열 만들어줘서 출력

 */

import java.io.*;
import java.util.*;

public class BOJ_7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) {
                hs.add(name);
            } else {
                hs.remove(name);
            }
        }

        
//        hs.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        String[] answer = hs.toArray(new String[hs.size()]);
        Arrays.sort(answer);

        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        for (int i = answer.length - 1; i >= 0; i--) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
    }
}
