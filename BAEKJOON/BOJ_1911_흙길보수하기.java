/*
 + 솔루션 찾기가 힘들었음
 + 나중에 다시 풀어보기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr, l));
    }


    public static int solution(int[][] input, int l){
        int answer = 0;
        int range = 0;

        Arrays.sort(input, (o1, o2) ->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            } else{
                return o1[0] - o2[0];
            }
        });

        for(int[] arr : input){
            if(arr[0] > range){
                range = arr[0];
            }

            if(arr[1] > range){
                while(arr[1] > range){
                    range += l;
                    answer++;
                }
            }
        }

        return answer;
    }
}

