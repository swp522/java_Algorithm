// 2020_11_01_일

/*

    1. 모든 트럭이 다리 건너는 최단시간 구하기

    2. 1 ≤ n ≤ 1,000  /  1 ≤ w ≤ 100   /  10 ≤ L ≤ 1,000

    3. 큐 써서 구현

       - 다리 하중보다 트럭들 무게가 커지는 경우 큐에 0 넣어주고 while문 break 안함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        solve(n, w, l, trucks);
    }

    public static void solve(int n, int w, int l, int[] trucks) {
        Queue<Integer> bridge = new LinkedList();

        int time = 0;
        int weight = 0;

        for (int i = 0; i < n; i++) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(trucks[i]);
                    time++;
                    weight += trucks[i];
                    break;
                } else if (bridge.size() == w) {
                    weight -= bridge.remove();
                } else {
                    if (weight + trucks[i] > l) {
                        bridge.offer(0);
                        time++;
                    } else {
                        bridge.offer(trucks[i]);
                        time++;
                        weight += trucks[i];
                        break;
                    }
                }
            }
        }

        System.out.println(time + w);
    }
}
