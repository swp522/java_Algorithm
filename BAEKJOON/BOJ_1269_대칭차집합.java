/*
1. 대칭 차집합 원소 개수 구하기

2. Set 자료구조

3. set : O(1)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        int duplication = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(setA.contains(temp)){
                duplication++;
            } else{
                setA.add(temp);
            }
        }
        answer = a + b - (duplication * 2);
        System.out.println(answer);
    }
}
