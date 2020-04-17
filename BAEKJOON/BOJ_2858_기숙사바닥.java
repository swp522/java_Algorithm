//2020_04_17_금_기숙사 바닥

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2858_기숙사바닥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int row = 0, col = 0;

        for (int i = 1; i <= 5000; i++) {
            for (int j = 1; j <= 4000; j++) {
                if (r + b == i * j) {
                    if (r == (i * 2) + (j - 2) * 2) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
        }

        System.out.println(row + " " + col);

    }
}
