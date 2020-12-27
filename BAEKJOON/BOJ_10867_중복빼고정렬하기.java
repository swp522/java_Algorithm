// 2020_12_27_일
// version 1.0

/*

    1. 중복 없이 정렬하기

    2. 1 ≤ N ≤ 100,000

    3. HashSet 으로 중복처리하고 리스트에 넣어서 정렬함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hs.add(num);
        }

        Iterator it = hs.iterator();
        ArrayList<Integer> answerList = new ArrayList();
        while (it.hasNext()) {
            answerList.add((Integer) it.next());
        }

        Collections.sort(answerList);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }
}
