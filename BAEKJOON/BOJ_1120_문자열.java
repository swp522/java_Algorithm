/*
1. 구현

2. O(n)

3. 시간 걸려서 스스로 해결함
  - 처음에 answer = 0; 으로 초기화 되어있어서 시간 날림

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        int answer = a.length();

        int len = b.length() - a.length();
        for(int i = 0; i < len + 1; i++){
            int temp = 0;
            for(int j = 0; j < a.length(); j++){
                if(a.charAt(j) != b.charAt(j + i)){
                    temp++;
                }
            }

            answer = Math.min(answer, temp);
        }

        System.out.println(answer);
    }
}
