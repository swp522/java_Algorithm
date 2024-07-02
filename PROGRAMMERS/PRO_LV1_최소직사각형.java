/* 20024.07.02 (화) 프로그래머스 Lv1.최소직사각형
 *
 * 정렬처리 후 배열에서 가로세로 가장 큰 값 구해서 곱한다
 *
 */
import java.util.Arrays;

public class PRO_LV1_최소직사각형 {
    public static void main(String[] args){
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxGaro = 0;
        int maxSero = 0;

        for(int i = 0; i < sizes.length; i++){
            Arrays.sort(sizes[i]);
        }

        for(int i = 0; i < sizes.length; i++){
            if(maxGaro < sizes[i][0]){
                maxGaro = sizes[i][0];
            }

            if(maxSero < sizes[i][1]){
                maxSero = sizes[i][1];
            }
        }
        answer = maxGaro * maxSero;
        return answer;
    }
}
