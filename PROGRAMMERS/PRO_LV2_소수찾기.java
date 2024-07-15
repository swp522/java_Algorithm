/* 2024.07.08 (월) PRO_LV2_소수찾기
 * DFS, 백트래킹 구현
 * 소수 구하기 : 에라토스체네의 체 이용
 */

import java.util.HashSet;

public class PRO_LV2_소수찾기 {
    static HashSet<Integer> set = new HashSet<Integer>();
    static boolean[] visited = new boolean[7];

    public static void main(String[] args){
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);

        for(Integer num : set){
            if(isSosu(num)){
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(String numbers, String s, int depth){
        if(depth > numbers.length()){
            return;
        }
        System.out.println(depth);
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    // 소수 판단 (에라토스테네의 체)
    public static boolean isSosu(int n){
        if(n < 2){
            return false;
        }

        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
