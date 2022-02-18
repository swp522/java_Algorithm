/*
2022.02.18(금)

1. 아이디어
- n개의 숫자를 정렬
- m개를 포문돌면서, 이진탐색 수행
- 이진탐색 안에서 마지막에 데이터 찾으면, 1출력, 아니면 0출력

2. 시간복잡도
- n개 입력값 정렬 = O(NlogN)
- m개를 n개중에서 탐색 = O(M * logN)
- 총합 : O((N+M)logN) > 가능

3. 자료구조
- int[] 1개 사용

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기_2nd {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = arr.length - 1;
            boolean flag = false;
            while(left <= right){
                int midIdx = (left + right) / 2;
                int midVal = arr[midIdx];
                if(midVal > num){
                    right = midIdx - 1;
                } else if(midVal < num){
                    left = midIdx + 1;
                } else{
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }

            if(!flag){
                System.out.println(0);
            }
        }
    }
}
