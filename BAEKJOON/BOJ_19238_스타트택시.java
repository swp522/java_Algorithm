// 2020_07_19_금_42회차_문풀1_스타트 택시

/*
 * 1. 남은 연료양 구하기 (연료 바닥나면 이동 못하면 -1 출력)
 *
 * 2. 2 ≤ N ≤ 20,  1 ≤ M ≤ N2,  1 ≤ 초기 연료 ≤ 500,000
 *
 * 3. 아직 미완성 - 우선순위큐 / 큐 2개 이용
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19238_스타트택시 {

    static int[][] map, person;
    static boolean[][] visited;
    static int n, m, answer, fuel, startX, startY;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Person implements Comparable<Person> {
        int x, y, num;

        public Person(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Person o) {
            if (this.num == o.num) {
                if (person[this.num][1] == person[o.num][1]) {
                    return person[this.num][2] - person[o.num][2];
                }
                return person[this.num][1] - person[o.num][1];
            }
            return this.num - o.num;
        }
    }

    static class Car {
        int x, y, fuel, count;

        public Car(int x, int y, int fuel, int count) {
            super();
            this.x = x;
            this.y = y;
            this.fuel = fuel;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 승객수
        fuel = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        person = new int[m][5];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 5; j++) {
                person[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        for (int t = 0; t < m; t++) {
            PriorityQueue<Person> pq = new PriorityQueue<>();
            visited = new boolean[n][n];
            Queue<Car> q = new LinkedList<>();
            visited[startX][startY] = true;
            q.add(new Car(startX, startY, fuel, 0));

            while (!q.isEmpty()) {
                Car car = q.poll();

                for(int i = 0; i < m; i++){
                    if(person[i][0] == 0 && person[i][1] == car.x && person[i][2] == car.y){

                    }
                }
            }

        }


    }



    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            return true;
        } else {
            return false;
        }
    }
}
