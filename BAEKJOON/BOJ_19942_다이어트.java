// 2020_11_16_월

/*

    1. 최저 영양소 기준 만족하는 최소 비용 + 식재료 번호 구하기

    2. 3 <= n <= 15

    3. 1) 조합으로 경우의수 다 구해주기

       2) 종료 조건에서 doSum()하고 기준 확인

       3) Sort 처리할 때 Class 하나 만들어줌. String 인자로 번호 처리해줌

    4. 스트링 빌더에 append 할 때 " " 까지 같이 해주니까 성공함
    
       (출력문에서 그냥 sb 길이만큼 charAt(i) + " " 하니까 틀렸습니다 나옴) 

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트 {

    public static class Node implements Comparable<Node> {
        String nums;
        int cost;

        public Node(String nums, int cost) {
            this.nums = nums;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost == o.cost) {
                return this.nums.compareTo(o.nums);
            }
            return cost - o.cost;
        }
    }

    static int n, mp, mf, ms, mv;
    static boolean[] visited;
    static int[][] input;
    static boolean check;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        input = new int[n][5];
        check = false;
        q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= n; i++) {
            dfs(0, 0, i);
        }


        if (check) {
            Node node = q.poll();
            System.out.println(node.cost);
            System.out.println(node.nums);
        } else {
            System.out.println(-1);
        }
    }


    public static void dfs(int index, int depth, int end) {
        if (depth == end) {
            doSum();
            return;
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1, end);
            visited[i] = false;
        }
    }


    public static void doSum() {
        int sumP = 0;
        int sumF = 0;
        int sumS = 0;
        int sumV = 0;
        int sumCost = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(i + 1).append(" ");
                sumP += input[i][0];
                sumF += input[i][1];
                sumS += input[i][2];
                sumV += input[i][3];
                sumCost += input[i][4];
            }
        }

        if (checkTheNutrient(sumP, sumF, sumS, sumV)) {
            check = true;
            q.add(new Node(sb.toString(), sumCost));
        }
    }


    public static boolean checkTheNutrient(int sumP, int sumF, int sumS, int sumV) {
        if (sumP >= mp && sumF >= mf && sumS >= ms && sumV >= mv) {
            return true;
        } else {
            return false;
        }
    }
}
