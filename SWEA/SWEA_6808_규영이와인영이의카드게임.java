// 2020_04_13_월_문풀_26회차_규영이와 인영이의 카드게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {

    static int[] gyuyoung, inyoung;
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            winCount = 0;
            loseCount = 0;
            gyuyoung = new int[9];
            inyoung = new int[9];
            boolean[] cards = new boolean[19];
            boolean[] played = new boolean[9];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyuyoung[i] = Integer.parseInt(st.nextToken());
                cards[gyuyoung[i]] = true;
            }

            int index = 0;
            for (int i = 1; i < cards.length; i++) {
                if (!cards[i]) {
                    inyoung[index] = i;
                    index++;
                }
            }

            nPr(0, played, 0, 0);

            System.out.println("#" + t + " " + winCount + " " + loseCount);
        }
    }

    public static void nPr(int index, boolean[] played, int gyu, int in) {
        if (index == 9) {
            if (gyu > in) {
                winCount++;
            } else {
                loseCount++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!played[i]) {
                played[i] = true;
                if (gyuyoung[index] > inyoung[i]) {
                    nPr(index + 1, played, gyu + gyuyoung[index] + inyoung[i], in);
                } else if (gyuyoung[index] < inyoung[i]) {
                    nPr(index + 1, played, gyu, in + gyuyoung[index] + inyoung[i]);
                }
                played[i] = false;
            }
        }
    }
}
