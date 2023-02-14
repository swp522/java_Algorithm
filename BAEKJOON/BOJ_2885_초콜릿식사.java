/*
 문제 이해하는데 시간 조금 걸림
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885_초콜릿식사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = 1;
        int count = 0;
        int answerSize = 0;

        while(k > size){
            size *= 2;
            answerSize = size;
        }

        while(k != 0){
            if(k >= size){
                k -= size;
            } else{
                size /= 2;
                count++;
            }
        }

        System.out.println(answerSize + " " + count);
    }
}
