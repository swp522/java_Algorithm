// 2020_06_01_월_문풀1_기차가 어둠을 헤치고 은하수를

/*
 * 1. 은하수 건널 수 있는 기차의 수 구하기
 *
 * 2. 1 ≤ x ≤ 20 , 1 ≤ N, M ≤ 100000
 *
 * 3. switch로 몀령에 따라 구현하고 StringBuilder로 버스 정보 넣고 HashSet써서 중복 제거하는 로직
 *
 *    전체적인 구현은 스스로 했으나 case 3 디버깅과 마지막 sb 사용하는 로직은 힌트 받음
 *
 *    구현문제인데, 비트마스크로 할 수 있는 듯
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15787_기차가어둠을헤치고은하수를 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] train = new int[n][20];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int trainNum;
            int seatNum;

            switch (command) {
                case 1:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    seatNum = Integer.parseInt(st.nextToken()) - 1;
                    train[trainNum][seatNum] = 1;
                    break;

                case 2:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    seatNum = Integer.parseInt(st.nextToken()) - 1;
                    train[trainNum][seatNum] = 0;
                    break;

                case 3:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    for (int j = 19; j > 0; j--) {
                        train[trainNum][j] = train[trainNum][j - 1];
                    }
                    train[trainNum][0] = 0;
                    break;

                case 4:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    for (int j = 0; j < 19; j++) {
                        train[trainNum][j] = train[trainNum][j + 1];
                    }
                    train[trainNum][19] = 0;
                    break;
            }
        }

        StringBuilder sb;
        HashSet<String> hs = new HashSet();
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                sb.append(train[i][j]);
            }
            hs.add(sb.toString());
        }

        System.out.println(hs.size());
    }
}
