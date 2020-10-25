// 2020_10_23_금

/*

    1. 몬스터 처치하는 최소 시간 구하기

    2. 1 ≤ N ≤ 5   /   1 ≤ HP ≤ 100000   /  1 ≤ C ≤ 10  /  (HP/10) ≤ D ≤ HP

       모든 스킬 쿨타임 다르고, 모든 D 합은 HP 보다 작다

    3. DP는 아니고 구현인 듯

       1) 초당 데미지 순으로 정렬 -> 이거 안해도 될듯

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_20008_몬스터를처치하자 {

    static int n, hp, answer;
    static int[][] skills;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        hp = Integer.parseInt(st.nextToken());
        skills = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            skills[i][0] = 0;
            skills[i][1] = Integer.parseInt(st.nextToken());
            skills[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skills, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return (o1[2] / o1[1]) - (o2[2] - o2[1]);
                    }
                }
        );
        
        
        dfs(0, hp);



    }

    public static void dfs(int time, int hp) {

    }
}