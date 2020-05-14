// 2020_05_11_월_문풀_35회차_드래곤커브

/*
 * 1. 드래콘 커브 일부에 꼭지점을 갖는 정사각형 개수 구하기
 *
 * 2. 0 ≤ x ≤ 100, 0 ≤ y ≤ 100, 0 ≤ g ≤ 10
 *
 * 3. 구현
 *
 *    예제 이해하는데 시간 오래걸렸고 로직 생각 못했음
 *
 *    정답 코드 참고
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {

    static int[][] map, dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[101][101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            makeDragonCurve(x, y, d, g);
        }

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }


    private static void makeDragonCurve(int x, int y, int d, int g) {

        ArrayList<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int j = 0; j < g; j++) {
            for(int k = dirList.size() - 1; k >= 0; k--){
                int newd = (dirList.get(k) + 1) % 4;
                dirList.add(newd);  // 0 , 0 1 , 0 1 2 1 , 0 1 2 1 2 3 2 1 이런 식으로 누적되어 list 에 add 됨
            }
        }

        map[x][y] = 1;

        for(int j = 0; j < dirList.size(); j++){
            x += dir[dirList.get(j)][0];
            y += dir[dirList.get(j)][1];
            map[x][y] = 1;
        }

        dirList.clear();
    }
}
