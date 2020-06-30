// 2020_06_30_화_44회차_과제2_생존자small

/*
 * 1. 무인도에서 생존할 수 있는 최대시간 구하기
 *
 * 2. 0 ≤ Pi(유통기한) ≤ 100 , 1 ≤ Si(에너지) ≤ 100
 *
 * 3. 구현, dfs
 * 
 * 4. 1). 문제를 대충 읽고 처음에 단순 구현했는데 틀림 -> 음식 순서가 정해진게 아니었음
 *
 *    2). Comparable 구현에서 시간 소비함
 *    
 *       - s가 같으면 p 오름차순 / s가 다르면 s 내림차순 정렬
 *       
 *    3). 재귀함수에서 인자를 갖고 다니지 않는데 time -= list.get(i).s; 안해줬었음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_12429_생존자small {

    static int n, answer, time;
    static int[][] foods;
    static boolean[] visited;
    static ArrayList<Food> list;

    static class Food implements Comparable<Food>{
        int p, s;

        public Food (int p, int s) {
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Food o) {
            if(this.s == o.s){
                if(this.p < o.s){
                    return -1;
                }
            }
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            foods = new int[n][2];
            visited = new boolean[n];
            list = new ArrayList<>();
            answer = 0;
            time = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                    foods[i][0] = Integer.parseInt(st.nextToken());
                    foods[i][1] = Integer.parseInt(st.nextToken());
                    list.add(new Food(foods[i][0], foods[i][1]));

            }

            Collections.sort(list);

            dfs();

            System.out.println("Case #" + t + ": " + answer);
        }
    }

    public static void dfs() {

        answer = Math.max(answer, time);

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i] && list.get(i).p >= time){
                visited[i] = true;
                time += list.get(i).s;
                dfs();
                time -= list.get(i).s;
                visited[i] = false;
            }
        }

    }
}
