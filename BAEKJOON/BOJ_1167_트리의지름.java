// 2020_09_28_월

/*
 * 1. 트리의 지름을 구하는 프로그램
 *
 * 2. 2 ≤ V ≤ 100,000   ,
 *
 * 3.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {

    static int v;

    static class Node {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    static ArrayList<Node> list[];

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
        
        dfs();



    }
    
    public static void dfs(){
        
    }
}
