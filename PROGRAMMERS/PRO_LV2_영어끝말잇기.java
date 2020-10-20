// 2020_10_20_화

import java.util.Arrays;
import java.util.HashMap;

public class PRO_LV2_영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> hm = new HashMap<>();
        Boolean finish = false;
        int people = 0;
        int turn = 1;

        for (int i = 0; i < words.length; i++) {
            people++;

            if (i > 0) {
                String now = words[i - 1];
                String next = words[i];
                if ((now.charAt(now.length() - 1) != next.charAt(0)) || hm.containsKey(next)) {
                    finish = true;
                    answer[0] = people;
                    answer[1] = turn;
                    break;
                }
            }

            hm.put(words[i], 1);

            if (people == n) {
                people = 0;
                turn++;
            }
        }

        if (!finish) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
