import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20044_ProjectTeams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2*n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;

        int temp = 0;
        for(int i = 0 ; i < n; i++){
            temp = arr[i] + arr[(2*n - 1) - i];
            answer = Math.min(temp, answer);
        }

        System.out.println(answer);
    }
}
