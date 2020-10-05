// 2020_09_28_월

/*
 * 1. 트리의 지름을 구하는 프로그램
 *
 * 2. 2 ≤ V ≤ 100,000   ,  거리는 모두 10,000 이하의 자연수
 *
 * 3. dfs
 *
 *    1). 1 번 node 에서 에서 가장 먼 노드(leaf) 찾기
 *
 *        (1번이 무조건 root 라는 보장은 없는 듯)
 *
 *    2). leaf 에서 가장 먼 노드 찾기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {

    static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static ArrayList<Node> list[];
    static int v, answer, leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            while (true) {
                int endPoint = Integer.parseInt(st.nextToken());
                if (endPoint == -1) {
                    break;
                }

                int distance = Integer.parseInt(st.nextToken());
                list[startPoint].add(new Node(endPoint, distance));
            }
        }

        dfs(1, 0, 0);
        dfs(leaf, 0, 0);

        System.out.println(answer);
    }


    public static void dfs(int currentNodeIndex, int parent, int weight) {
        if (weight > answer) {
            answer = weight;
            leaf = currentNodeIndex;
        }

        for (int i = 0; i < list[currentNodeIndex].size(); i++) {
            Node next = list[currentNodeIndex].get(i);

            if (next.index != parent) {
                dfs(next.index, currentNodeIndex, weight + next.weight);
            }
        }

    }
}
