// 2020_05_08_금_과제_34회차_문자열 잘라내기

/*
 * 1. 행 지우는 횟수(count) 출력하기
 *
 * 2. 2 ≤ R, C ≤ 1000
 *
 * 3. 이분 탐색, 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2866_문자열잘라내기 {

    static int row, col, answer;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new String[row][col];
        answer = 0;

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = String.valueOf(input.charAt(j));
            }
        }

        binarySearch(0, row - 1, row - 1);

        System.out.println(answer);
    }


    public static void binarySearch(int left, int right, int end) {


        if (left > right) {
            return;
        }

        int mid = (left + right) / 2;

        boolean flag = check(mid, end);

        if (flag) {
            if (answer < mid) { // 중복 발생 안한 행 중 최대값이 answer
                answer = mid;
            }
            binarySearch(mid + 1, right, end);   // 중복 없으면 mid + 1부터 검사
        } else {
            binarySearch(left, mid - 1, end);    // 중복 있으면 mid -1 까지만 검사
        }
    }


    public static boolean check(int start, int end) {

        for (int i = start; i <= end; i++) {

            ArrayList<String> list = new ArrayList<>();

            for (int j = 0; j < col; j++) {
                String temp = map[start][j];

                if (list.contains(temp)) {
                    return false;
                }

                list.add(temp);

            }
        }
        return true;
    }

}
