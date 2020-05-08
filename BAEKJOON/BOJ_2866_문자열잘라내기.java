// 2020_05_08_금_과제_34회차_문자열 잘라내기

/*
 * 1. 행 지우는 횟수(count) 출력하기
 *
 * 2. 2 ≤ R, C ≤ 1000
 *
 * 3. 이분 탐색, 구현
 *
 * 4. check()에서 tmp 만들어주는게 시간이 많이 걸리는 듯 하다 !
 *
 *    check()에서 행의 끝까지 tmp 만들어주고 중복 체크해야함 -> tmp에 acdbbb 이렇게 들어간 경우
                                                                 acdccc
 *
 *    bbb, ccc는 중복이 아니니까 start부터 row(끝) 까지 for문 돌아야함
 *
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

        binarySearch(1, row - 1);
    }


    public static void binarySearch(int left, int right) {

        boolean flag = true;
        int mid = 0;

        while (left <= right) {

            mid = (left + right) / 2;

            flag = check(mid, right);

            if (flag) {
                left = mid + 1; // 중복 없으면 mid + 1부터 검사
            } else {
                right = mid - 1;    // 중복 있으면 mid -1 까지만 검사
            }
        }

        if (!flag) {
            System.out.println(mid - 1);
        } else {
            System.out.println(mid);
        }
    }


    public static boolean check(int start, int end) {

        ArrayList<String> list = new ArrayList<>();

        for (int j = 0; j < col; j++) {
            String tmp = "";
            for (int i = start; i <= row; i++) {
                tmp += map[i][j];
            }
            if (list.contains(tmp)) {
                return false;
            } else {
                list.add(tmp);
            }
        }
        return true;
    }

}

//        if (left > right) {
//            return;
//        }
//
//        int mid = (left + right) / 2;
//
//        boolean flag = check(mid, end);
//
//        if (flag) {
//            if (answer < mid) { // 중복 발생 안한 행 중 최대값이 answer
//                answer = mid;
//            }
//            binarySearch(mid + 1, right, end);   // 중복 없으면 mid + 1부터 검사
//        } else {
//            binarySearch(left, mid - 1, end);    // 중복 있으면 mid -1 까지만 검사
//        }
