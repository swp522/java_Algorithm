// 2020_06_10_수_점심식사시간

/*
 * 1. 이동이 완료되는 최소의 시간 구하기
 *
 * 2. 4 ≤ N ≤ 10,  1 ≤ 사람의 수 ≤ 10,  계단 2개,  2 ≤ 계단의 길이 ≤ 10,  계단 위에는 최대 3명만
 *
 * 3. 1). 조합으로 계단 결정
 *
 *    2). 계단에 있는 사람들 따로 class 만듬
 *
 * 4. 아직 미완성...
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2383_점심식사시간 {
    static int n, answer;
    static int[][] map, down;
    static int[] check;
    static ArrayList<Point> peopleList;
    static ArrayList<Point> stairList;
    static PriorityQueue<PointInStair> pq;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static class PointInStair implements Comparable<PointInStair> {
        int time, stair, status;

        public PointInStair(int time, int stair, int status) {
            this.time = time;
            this.stair = stair;
            this.status = status;
        }

        @Override
        public int compareTo(PointInStair o) {
            if (this.time == o.time) {
                return o.status - this.status;
            } else {
                return this.time - o.time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;

            map = new int[n][n];
            down = new int[2][3];
            peopleList = new ArrayList<>();
            stairList = new ArrayList<>();

            int index = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        peopleList.add(new Point(i, j));
                    } else if (map[i][j] > 1) {
                        stairList.add(new Point(i, j));
                    }
                }
            }

            check = new int[peopleList.size()];

            nCr(0);

            System.out.println("#" + t + " " + answer);
        }
    }


    public static void nCr(int index) {
        if (index == peopleList.size()) {

            pq = new PriorityQueue<>();

            for (int i = 0; i < index; i++) {
                int peopleX = peopleList.get(i).x;
                int peopleY = peopleList.get(i).y;
                int stairX = stairList.get(i).x;
                int stairY = stairList.get(i).y;
                int moveTime = Math.abs(peopleY - stairY) + Math.abs(peopleX - stairX);
                pq.add(new PointInStair(moveTime, i, -1));


            }

        }
    }


    public static void passTheStair() {

    }
}
