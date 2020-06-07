// 2020_06_07_일_영역 구하기

/*
 * 1. 분리된 영역 수와 각 영역의 넓이 구하기
 *
 * 2. M, N, K <= 100 의 자연수
 *
 * 3. 구현
 *
 * 4. 시간 줄여보기
 *
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2583_영역구하기 {

    static boolean[][] check;
    static int m, n;
    static int count = 0;
    static Queue<String> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());
        int[] vertex = new int[4];
        check = new boolean[m][n];

        LinkedList<Integer> sizeArr = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < vertex.length; j++) {
                vertex[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = vertex[0]; j < vertex[2]; j++) {
                for (int l = vertex[1]; l < vertex[3]; l++) {
                    check[l][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false) {
                    count = 1;
                    check[i][j] = true;
                    solve(i, j);
                    sizeArr.add(count);
                }
            }
        }

        sizeArr.sort(null);
        bw.write(sizeArr.size() + "\n");
        for (int i = 0; i < sizeArr.size(); i++) {
            bw.write(sizeArr.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }


    public static void solve(int x, int y) {
        if (x > 0 && check[x - 1][y] == false) {
            check[x - 1][y] = true;
            queue.add((x - 1) + "," + y);
        }
        if (x < m - 1 && check[x + 1][y] == false) {
            check[x + 1][y] = true;
            queue.add((x + 1) + "," + y);
        }
        if (y > 0 && check[x][y - 1] == false) {
            check[x][y - 1] = true;
            queue.add(x + "," + (y - 1));
        }
        if (y < n - 1 && check[x][y + 1] == false) {
            check[x][y + 1] = true;
            queue.add(x + "," + (y + 1));
        }
        if (!queue.isEmpty()) {
            String str = queue.poll();
            count++;
            solve(Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1]));
        }
    }

}
