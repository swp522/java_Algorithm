/*
2022.02.14(월)
1. 아이디어 :
- 이중 for 문 > 값 1 && 방문X > BFS
- bfs 돌면서 그림 개수 + 1, 최대값 갱신

2. 시간 복잡도
- O(E + V)
- V : M X N, E = V X 4
- V : 500 * 500, E : 4 * 500 * 500
- V + E : 5 * 250000 = 100만 < 2억 -> 가능함 !!

3. 자료구조
- 그래프 전체 지도 : int[][]
- 방문 : bool[][]
- queue(for bfs)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static int n, m, count, maxSize;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }


    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        count++;
        int size = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            size++;

            for (int d = 0; d < 4; d++) {
                int dx = node.x + dir[d][0];
                int dy = node.y + dir[d][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
                if (visited[dx][dy] || map[dx][dy] == 0) continue;

                visited[dx][dy] = true;
                q.add(new Node(dx, dy));
            }
        }

        maxSize = Math.max(maxSize, size);
    }
}

// 아래 노드 클래스를 메인 클래스 안에 넣으면 에러남. -> 원인 생각해보기 !!
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}