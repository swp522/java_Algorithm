// 2020_10_04_일

/*
 * 1. 트리의 지름을 구하기
 *
 * 2. 1 ≤ n ≤ 10,000
 *
 * 3. dfs (다익스트라도 가능)
 *
 *    1). root에서 가장 먼 노드 찾기
 *
 *    2). 그 점에서 가장 먼 노드 찾기
 *
 *    3). 두 노드 사이거리가 지름
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {

    static class Node {
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static boolean visited[];
    static int n, maxWeight;
    static Node maxWeightNode;
    static LinkedList<Node> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        for (Node root : tree[1]) {
            visited[1] = true;
            dfs(root, root.weight);
            visited[1] = false;
        }

        maxWeight = 0;

        dfs(maxWeightNode, 0);

        System.out.println(maxWeight);
    }


    public static void dfs(Node node, int weight) {
        visited[node.index] = true;

        for (Node i : tree[node.index]) {
            if (!visited[i.index]) {
                visited[i.index] = true;
                dfs(i, weight + i.weight);
                visited[i.index] = false;
            }
        }

        if (weight > maxWeight) {
            maxWeightNode = node;
            maxWeight = weight;
        }

        visited[node.index] = false;
    }
}

