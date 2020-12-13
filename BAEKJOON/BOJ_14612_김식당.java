// 2020_12_12_톼

/*

    1. 명령어 수행후 각각의 경우 테이블 번호 출력하기

    2. 1 ≤ N,  M ≤ 100,  1 ≤ 주문 시간 ≤ 1,000 , 1 ≤ 테이블 번호 ≤ M

    3. 조건 별 구현

       처음에 명령어별로 나눠서 입력받으면 좀 더 편리할듯

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14612_김식당 {

    static int tableNum, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] order = new String[n];
        for (int i = 0; i < n; i++) {
            order[i] = br.readLine();
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (String o : order) {
            st = new StringTokenizer(o);
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                tableNum = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens()) {
                time = Integer.parseInt(st.nextToken());
            }

            if (command.equals("order")) {
                list.add(new int[]{tableNum, time});
            } else if (command.equals("sort")) {
                Collections.sort(list, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] > o2[1]) {
                            return 1;
                        } else if (o1[1] == o2[1]) {
                            return o1[0] > o2[0] ? 1 : -1;
                        }

                        return -1;
                    }
                });
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i)[0] == tableNum) {
                        list.remove(i);
                        break;
                    }
                }
            }

            if (list.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)[0]);
                    if (i < list.size() - 1) {
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("sleep");
            }
        }
    }
}
