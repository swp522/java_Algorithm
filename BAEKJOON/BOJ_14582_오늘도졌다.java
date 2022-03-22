/*
1. 구현 문제, 그리디 알고리즘

2. O(n)

3. -야구 규칙을 생각했어야 했음 (1회 초-울림 공격 sumA 기준으로 생각)
   -return 활용
   -문제 잘 읽기 : 항상 울림이 지는 경기 / 울림이 먼저 공격

 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14582_오늘도졌다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[9];
        int sumA = 0;
        int sumB = 0;

        for(int i = 0; i < 9; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 9; i++){
            sumA += a[i];
            if(sumA > sumB){
                System.out.print("Yes");
                return;
            }

            sumB += Integer.parseInt(st.nextToken());
        }

        System.out.println("No");
    }
}
