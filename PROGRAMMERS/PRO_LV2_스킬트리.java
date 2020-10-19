// 2020_10_19_월

/*

    1. 스킬트리 개수 구하기

    2. 범위 작음

    3. 구현

    4. 처음에 무슨 자료구조 쓸지 생각이 잘 안났음

 */

public class PRO_LV2_스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }


    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int indexNum = 0;
            boolean check = false;
            String[] arr = skill_trees[i].split("");

            for (int j = 0; j < arr.length; j++) {
                if (indexNum == skill.indexOf(arr[j])) {
                    indexNum++;
                } else if (indexNum < skill.indexOf(arr[j])) {
                    check = true;
                    break;
                } else {
                    continue;
                }
            }

            if (!check) {
                answer++;
            }
        }

        return answer;
    }
}
