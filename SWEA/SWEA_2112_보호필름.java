// 2020_06_17_수_보호 필름

/*
 * 1. 성능 검사 통과할 수 있는 최소 약품 투여 횟수 구하기
 *
 * 2. 3 ≤ D ≤ 13 , 1 ≤ W ≤ 20, 1 ≤ K ≤ D
 *
 * 3. 1). 약 투여 x / a 투여 / b 투여 하는 3가지 경우 dfs()
 *
 *    2). 성능 검사
 *
 *    3). k == 0 일때 처리
 *
 * 4. 구현하기 어려웠다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

    static int d, w, k, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());   // 두께
            w = Integer.parseInt(st.nextToken());   // 가로 크기
            k = Integer.parseInt(st.nextToken());   // 합격 기준
            answer = Integer.MAX_VALUE;
            map = new int[d][w];

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(k == 1){
                System.out.println("#" + t + " " + 0);
                continue;
            }

            dfs(0, 0);

            System.out.println("#" + t + " " + answer);
        }
    }


    public static void dfs(int depth, int countOfInjection) {
        if (countOfInjection >= answer) {
            return;
        }

        if (depth == d) {
            if (qualityTest()) {
                answer = Math.min(answer, countOfInjection);
            }
            return;
        }

        dfs(depth + 1, countOfInjection);

        int[] copy = new int[w];
        for (int i = 0; i < w; i++)
            copy[i] = map[depth][i];

        for(int i = 0; i < w; i++){
            map[depth][i] = 0;
        }
        dfs(depth + 1, countOfInjection + 1);


        for(int i = 0; i < w; i++){
            map[depth][i] = 1;
        }
        dfs(depth + 1, countOfInjection + 1);

        for (int i = 0; i < w; i++)
            map[depth][i] = copy[i];
    }


    public static boolean qualityTest() {
        for (int j = 0; j < w; j++) {
            boolean check = false;
            for (int i = 0; i <= d - k; i++) {

                check = true;

                for (int a = 1; a < k; a++) {

                    if (map[i][j] != map[i + a][j]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    break;
                }   // 하나라도 연속된거 있으면 그 열 pass

            }

            if (!check) {
                return false;
            }   // 해당 열이 연속된거 없으면 test 실패임

        }
        return true;
    }

}
