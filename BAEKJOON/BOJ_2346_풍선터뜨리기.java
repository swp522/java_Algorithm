// 2020_11_19_목

/*

    1. 터지는 순서대로 풍선의 순서 출력하기

    2. 1 <= n <= 1000

    3. 1) 풍선의 값이 양수/음수 인 경우 구분해서 구현

       2) 배열의 범위를 넘어가는 구간 처리해줘야함

       3) 구현하는데 시간 좀 걸렸음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        ArrayList<Integer> answerList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int indexForTarget = 0;
        while (true) {
            visited[indexForTarget] = true;
            answerList.add(indexForTarget + 1);

            if (answerList.size() == n) {
                break;
            }

            int tempForBalloonNum = 0;
            int balloonNum = arr[indexForTarget];

            if (balloonNum > 0) {
                while (true) {
                    indexForTarget++;
                    if(indexForTarget == n){
                        indexForTarget %= (n - 1);
                    }

                    if (!visited[indexForTarget]) {
                        tempForBalloonNum++;
                        if (tempForBalloonNum == balloonNum) {
                            break;
                        }
                    }
                }
            } else {
                balloonNum = Math.abs(balloonNum);
                while (true) {
                    indexForTarget--;
                    if (indexForTarget < 0) {
                        indexForTarget = n - 1;
                    }

                    if (!visited[indexForTarget]) {
                        tempForBalloonNum++;
                        if (tempForBalloonNum == balloonNum) {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }
}
