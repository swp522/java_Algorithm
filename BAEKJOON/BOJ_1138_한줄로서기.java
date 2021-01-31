// 2020_02_01_월

/*

    1. 줄을 어떻게 서야하는지 구하기

    2. n <= 10, 0 <= i번쨰 수 <= n - i

    3. 리스트에 임의로 숫자 넣어놓고, 배열의 index 로 이용함

       구현 문제인데 뭔가 자료구조로 로직 짜는게 조금 꼬인 것 같음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int index = list.remove(Integer.parseInt(st.nextToken()));
            arr[index] = i;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
