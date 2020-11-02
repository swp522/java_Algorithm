// 2020_11_02_월

/*

    1. 로프들로 들어올릴 수 있는 최대 중량 구하기

    2. 1 ≤ N(로프 개수) ≤ 100,000

    3. 구현
    
       - else 문 안에 conitnue 해주는 실수 없애기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int temp = n;
        int answer = 0;
        for (int i = 0; i < ropes.length; i++) {
            if(ropes[i] * temp > answer){
                answer = ropes[i] * temp;
            }

            temp--;
        }

        System.out.println(answer);
    }
}
