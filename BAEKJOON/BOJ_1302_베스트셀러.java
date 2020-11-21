// 2020_11_21_토

/*

    1. 가장 많이 팔린 책 제목 출력하기

    2. N <= 1000

    3. 1) HashMap 으로 입력 받기

       2) keySet()으로 전체 book 중 maxNuM 찾기

       3) answerList 정렬하고 maxNum 과 같은거 출력

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (hm.containsKey(book)) {
                hm.replace(book, hm.get(book) + 1);
            } else {
                hm.put(book, 1);
            }
        }

        int maxNum = 0;
        for (String book : hm.keySet()) {
            int num = hm.get(book);
            maxNum = Math.max(num, maxNum);
        }

        ArrayList<String> answerList = new ArrayList<>(hm.keySet());
        Collections.sort(answerList);

        for(int i = 0; i < answerList.size(); i++){
            if(hm.get(answerList.get(i)) == maxNum){
                System.out.println(answerList.get(i));
                break;
            }
        }
    }
}
