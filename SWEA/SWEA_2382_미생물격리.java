// 2020_06_03_수_문풀1_17회차_미생물 격리

/*
 * 1. M 시간후 남아 있는 미생물 수의 합
 *
 * 2. 5 ≤ N ≤ 100, 1 ≤ M ≤ 1,000, 5 ≤ K ≤ 1,000
 *
 * 3. 조건에 알맞게 구현
 *
 * 4. LinkedList에서 ArrayList로 바꿨더니 시간초과 해결
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {

    static int n, m, k, answer;
    static int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};    // 0, 상, 하, 좌 우
    static int[] changedDir = {0, 2, 1, 4, 3};

    static class Microbes {
        int row, col, num, moveDir;
        boolean isDead;

        public Microbes(int row, int col, int num, int moveDir, boolean isDead) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.moveDir = moveDir;
            this.isDead = isDead;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());   // 격리 시간
            k = Integer.parseInt(st.nextToken());   // 군집 개수

            answer = 0;
            ArrayList<Microbes> list = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int moveDir = Integer.parseInt(st.nextToken());
                list.add(new Microbes(row, col, num, moveDir, false));
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < list.size(); j++) {
                    Microbes micro = list.get(j);
                    if (!micro.isDead) {
                        micro.row = micro.row + dir[micro.moveDir][0];
                        micro.col = micro.col + dir[micro.moveDir][1];
                    }
                }

                for (int j = 0; j < list.size(); j++) {
                    Microbes micro = list.get(j);
                    if (micro.isDead) {
                        continue;
                    }
                    if (isRangeOut(micro.row, micro.col)) {
                        list.get(j).num /= 2;
                        if (list.get(j).num == 0) {
                            list.get(j).isDead = true;
                        }
                        list.get(j).moveDir = changedDir[micro.moveDir];
                    } else {
                            int max = micro.num;
                            int sum = micro.num;
                            int index = j;

                            for (int k = j + 1; k < list.size(); k++) {

                                if (!list.get(k).isDead) {
                                    if (list.get(k).row == micro.row && list.get(k).col == micro.col) {
                                        if (max > list.get(k).num) {
                                            sum += list.get(k).num;
                                            list.get(k).isDead = true;
                                        } else {
                                            sum += list.get(k).num;
                                            max = list.get(k).num;
                                            list.get(index).isDead = true;
                                            index = k;
                                        }
                                    }
                                }
                            }

                            list.get(index).num = sum;
                        }

                }
            }

            for (int a = 0; a < list.size(); a++) {
                if (!list.get(a).isDead) {
                    answer += list.get(a).num;
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }


    public static boolean isRangeOut(int x, int y) {
        if (x == 0 || y == 0 || x == n - 1 || y == n - 1) {
            return true;
        }
        return false;
    }

}
