/*
 슬라이딩 윈도우 기본 문제
 - 문자를 원형으로 생각하여 마지막 인덱스를 고려하고 % 연산자로 인덱싱해줘야함 (27 line)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int aCount = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'a'){
                aCount++;
            }
        }

        int answer = input.length();
        int bCount;
        for(int i = 0; i < input.length(); i++){
            bCount = 0;
            for(int j = i; j < i + aCount; j++){
                if(input.charAt(j % input.length()) == 'b'){
                    bCount++;
                }
            }
            answer = Math.min(answer, bCount);
        }

        System.out.println(answer);
    }
}
