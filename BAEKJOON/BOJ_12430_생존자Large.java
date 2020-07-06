// 2020_06_30_화_44회차_과제2_생존자small

/*
 * 1. 무인도에서 생존할 수 있는 최대시간 구하기
 *
 * 2. 1 ≤ N(음식 개수) ≤ 1000.  ,  0 ≤ Pi(유통기한) ≤ 100000 , 1 ≤ Si(에너지) ≤ 1000
 *
 * 3. dp 구현
 *
 * 4. 1). Small 버전 코드로 돌리면 시간초과 뜸
 *
 *    2). 로직 생각중
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_12430_생존자Large {

    static int n, answer, max;
    static int[][] foods;
    static boolean[] dp;
    static ArrayList<Food> list;

    static class Food implements Comparable<Food>{
        int p, s;

        public Food(int p, int s) {
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Food o) {
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            foods = new int[n][2];
            list = new ArrayList<>();   //list.clear()랑 차이 많이 있을까 궁금함..
            answer = 0;
            max = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                foods[i][0] = Integer.parseInt(st.nextToken());
                foods[i][1] = Integer.parseInt(st.nextToken());
                list.add(new Food(foods[i][0], foods[i][1]));
            }

            Collections.sort(list);
            max = list.get(n - 1).p + list.get(n - 1).s;

            dp = new boolean[100001];


            System.out.println("Case #" + t + ": " + answer);
        }
    }

}
