/*
1. 아이디어
- 그냥 이중 for문보다 투포인터가 더 빠름
- for문으로 처음에 k개값을 저장
- 다음 인덱스 더해주고, 이전 인덱스 빼줌
- 이때마다 최대값을 갱신

2. 시간 복잡도
- O(N) = 1e^5 -> 가능

3. 자료구조
- 각 숫자들 n개 저장 배열 : int[]
     숫자들 최대 100 -> int 가능
- k개의 값을 저장하는 변수 : int
     최대 : k * 100 = 1e^5 * 100 = 1e^7 -> Int 가능
- 최대값 : int
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {

    static int n, k, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        generalSolution();
        twoPointerSolution();

        System.out.println(max);
    }

    public static void generalSolution(){
        for(int i = 0; i < n - k + 1; i++){ // + 1 해준거 생각
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }
            max = Math.max(sum, max);
        }
    }

    public static void twoPointerSolution(){
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        max = sum;
        for(int i = k; i < n; i++){
            sum = sum - arr[i - k] + arr[i];
            max = Math.max(sum, max);
        }

    }
}
