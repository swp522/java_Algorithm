/*
1. 구현

2. O(n)

3. 큐 사용해서 구현하는 기본 문제

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue q = new LinkedList();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(q.size() != 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
