//2020_04_03_금_과제_23회차_팰린드롬 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213_팰린드롬만들기 {

    static int oddCount;
    static char oddChar;
    static int[] alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        alphabets = new int[26];
        oddCount = 0;
        oddChar = ' ';

        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i) - 'A';
            alphabets[value]++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                if (alphabets[i] % 2 == 1) {
                    oddCount++;
                    oddChar = (char) (i + 'A');
                }
            }
        }

        //홀수개인 알파벳이 2개 이상인 경우
        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
        }
        else{
            solve();
        }
    }


    public static void solve() {

        String answer = "";
        String reversedAnswer = "";
        String temp;

        //모든 알파벳이 짝수개인 경우
        if (oddCount == 0) {
            for (int i = 0; i < 26; i++) {
                if (alphabets[i] != 0) {

                    int half = alphabets[i] / 2;
                    for (int j = 0; j < half; j++) {
                        answer = answer + (char) (i + 'A');
                    }
                }
            }
            temp = new StringBuilder(answer).reverse().toString();
            reversedAnswer = temp;
            answer = answer + reversedAnswer;
            System.out.println(answer);
        }

        //한 알파벳만 홀수개이고 나머지 다 짝수개
        else {
            for (int i = 0; i < 26; i++) {
                if (alphabets[i] != 0) {

                    int half = alphabets[i] / 2;
                    for (int j = 0; j < half; j++) {
                        answer = answer + (char) (i + 'A');
                    }
                }
            }
            temp = new StringBuilder(answer).reverse().toString();
            reversedAnswer = temp;
            answer = answer + oddChar + reversedAnswer;
            System.out.println(answer);
        }
    }
}
