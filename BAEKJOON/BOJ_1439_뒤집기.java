import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split("");
        int zeroCount = 0;
        int oneCount = 0;

        if(arr[0].equals("0")){
            zeroCount++;
        } else{
            oneCount++;
        }

        for(int i = 1; i < arr.length; i++){
            if(!arr[i - 1].equals(arr[i])){
                if(arr[i].equals("0")){
                    zeroCount++;
                } else{
                    oneCount++;
                }
            }
        }

        System.out.print(Math.min(zeroCount, oneCount));
    }
}
