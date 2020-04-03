//2020_04_03_금_PRO 문풀

import java.util.ArrayList;
import java.util.Collections;

public class PRO_LV1_문자열내맘대로정렬하기 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(solution(strings, n));
    }

    public static String[] solution(String[] strings, int n) {
        ArrayList<String> array = new ArrayList<String>();

        for (int i = 0; i < strings.length; i++) {
            array.add(strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(array);

        String[] answer = new String[array.size()];

        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i).substring(1, array.get(i).length());
        }
        return answer;
    }
}
