//2020_03_22_일

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            int[] temp = new int[end - start + 1];
            
            // 1. 잘린 배열
            for(int j = 0; j<temp.length; j++){
                temp[j] = array[start -1 + j];
            }
            // 2. 정렬
            Arrays.sort(temp);
            // 3. answer의 i번째 값을 정렬된 배열의 k번째 숫자로 지정
            answer[i] = temp[k - 1];
        }
        return answer;
    }
}