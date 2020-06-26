// 2020_06_26_금_43회차_과제2_행성연결

/*
 * 1. 모든 행성 연결 시 최소 플로우의 관리 비용구하기
 *
 * 2. 1 ≤ N ≤ 1000 ,  1 ≤ Cij ≤ 100,000,000
 *
 * 3. 1). MST, 크루스칼 알고리즘 구현
 *
 *    2). long sum
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16398_행성연결 {

    static int n;
    static long sum;
    static int[][] map;
    static ArrayList<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i < j){
                    edgeList.add(new Edge(i, j, map[i][j]));
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                edgeList.add(new Edge(i, j, map[i][j]));
//            }
//        }

        Collections.sort(edgeList);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        sum = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (!isSameParent(edge.v1, edge.v2)) {
                unionParent(edge.v1, edge.v2);
                sum += edge.cost;
            }
        }

        System.out.println(sum);
    }


    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = getParent(parent[x]);
        }
    }


    public static void unionParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }


    public static boolean isSameParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost < o.cost)
                return -1;
            else if (this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }

}
