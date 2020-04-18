import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3431_준환이의운동관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if(l <= x && x <= u){
                System.out.println("#" + t + " " + 0);
            }
            else if(x > u){
                System.out.println("#" + t + " " + -1);
            }
            else if(x < l){
                int answer = l - x;
                System.out.println("#" + t + " " + answer);
            }
        }
    }
}
