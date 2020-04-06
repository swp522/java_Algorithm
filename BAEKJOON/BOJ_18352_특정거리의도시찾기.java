// 2020_04_03_금_과제_23회차_특정 거리의 도시 찾기
// map 그려서 탐색 -> 시간초과
// bfs + 인접리스트 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {

    static int n, m, k, x;
    static ArrayList[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        answer = new int[n + 1];    // visit 과 distance 둘다 처리

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);     // [[2, 3], [3, 4], []...]  단방향 정보
        }

        bfs();

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (answer[i] == k) {
                check = true;
                System.out.println(i);
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }

    public static void bfs() {

        Queue<City> q = new LinkedList<>();
        answer[x] = -1; // 출발점에서 [i] 까지의 distance 의미함. x에서 x 로 가는 경우는 -1로 설정
        for (int i = 0; i < list[x].size(); i++) {
            q.add(new City((int) list[x].get(i), 1));   //출발점(x)번째 리스트에서
            answer[(int) list[x].get(i)] = 1;
        }

        while (!q.isEmpty()) {
            City c = q.poll();

            if (c.distance <= k) {  // k = 2
                for (int i = 0; i < list[c.end].size(); i++) {  //c.end는 처음에 2, 3

                    if (answer[(int) list[c.end].get(i)] == 0) {
                        q.add(new City((int) list[c.end].get(i), c.distance + 1));
                        answer[(int) list[c.end].get(i)] = c.distance + 1;
                    }
                }
            }
        }
    }

    static class City {
        int end, distance;

        public City(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
