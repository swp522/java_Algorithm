// 2020_05_27_수_문풀1_16회차_이차원 배열과 연산

/*
 * 1. map[r][c] = k 가 되기 위한 최소 시간
 *
 * 2. 1 ≤ r, c, k ≤ 100 , map[][] <= 100
 *
 * 3. 0은 정렬할 때 무시
 *
 *    row 와 col 길이에 따라서 연산 구분
 *
 *    행 > 100 이면 처음 100개를 제외한 나머지는 버림
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {

    static int r, c, k;
    static int[][] map;
    static int[] count;
    static ArrayList<Num> list;

    static class Num implements Comparable<Num> {
        int number, len;

        Num(int number, int len) {
            this.number = number;
            this.len = len;
        }

        @Override
        public int compareTo(Num o) {
            if (this.len == o.len) {
                return this.number < o.number ? -1 : 1;
            }
            return this.len < o.len ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1;

        while (true) {
            time++;

            if (time > 100) {
                time = -1;
                break;
            }

            if (r < map.length && c < map[0].length) {
                if (map[r][c] == k) {
                    break;
                }
            }

            int row = map.length;
            int col = map[0].length;

            int[][] arr = new int[101][101];   // {숫자, 개수, 숫자, 개수, ...}


            // R연산
            if (row >= col) {

                int max = Integer.MIN_VALUE;

                for (int i = 0; i < row; i++) {
                    count = new int[101];
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] == 0) {
                            continue;
                        }
                        count[map[i][j]]++;
                    }

                    list = new ArrayList<>();

                    for (int j = 1; j < count.length; j++) {
                        if (count[j] != 0) {
                            list.add(new Num(j, count[j]));
                        }
                    }

                    Collections.sort(list);

                    int a = 0;
                    for (int j = 0; j < list.size(); j++) {
                        arr[i][a] = list.get(j).number;
                        arr[i][a + 1] = list.get(j).len;
                        a += 2;
                    }   // {숫자, 개수, 숫자, 개수, ...}

                    if (max < list.size() * 2) {
                        max = list.size() * 2;
                    }
                }

                if (max > 100) {
                    max = 100;
                }

                map = new int[row][max];

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        map[i][j] = arr[i][j];
                    }
                }
            }

            // C연산
            else {
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < col; i++) {
                    count = new int[101];

                    for (int j = 0; j < row; j++) {

                        if (map[j][i] == 0) {
                            continue;
                        }
                        count[map[j][i]]++;
                    }

                    list = new ArrayList<>();

                    for (int j = 1; j < count.length; j++) {
                        if (count[j] != 0) {
                            list.add(new Num(j, count[j]));
                        }
                    }

                    Collections.sort(list);

                    int a = 0;
                    for (int j = 0; j < list.size(); j++) {
                        arr[a][i] = list.get(j).number;
                        arr[a + 1][i] = list.get(j).len;
                        a += 2;
                    }

                    if (max < list.size() * 2) {
                        max = list.size() * 2;
                    }
                }

                if (max > 100) {
                    max = 100;
                }

                map = new int[max][col];

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        map[i][j] = arr[i][j];
                    }
                }
            }
        }

        System.out.println(time);
    }
}