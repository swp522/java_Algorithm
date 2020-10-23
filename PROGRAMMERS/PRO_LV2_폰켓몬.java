// 2020_10_23_금

import java.util.HashSet;

public class PRO_LV2_폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int limit = nums.length / 2;
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        if (hs.size() > limit) {
            answer = limit;
        } else if (hs.size() == limit) {
            answer = hs.size();
        } else if (hs.size() < limit) {
            answer = hs.size();
        }

        return answer;
    }

}
