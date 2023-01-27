import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2822_점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = new int[8];
        int[] arr2 = new int[8];
        int[] answer = new int[5];
        int sum = 0;
        int temp;
        for(int i = 0; i < 8; i++){
            temp = Integer.parseInt(br.readLine());
            arr1[i] = temp;
            arr2[i] = temp;
        }

        Arrays.sort(arr2);

        for(int i = 3; i < 8; i++){
            sum += arr2[i];
            for(int j = 0; j < 8; j++){
                if(arr2[i] == arr1[j]){
                    answer[i - 3] = j + 1;
                }
            }
        }

        System.out.println(sum);
        Arrays.sort(answer);
        for(int i = 0 ; i < 5; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
