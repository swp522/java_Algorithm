/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 4시간
*/

import java.io.*;

public class BOK10989_CountingSort {
    static int max = 0;
    static int[] inputData;
    static int[] countData;
    static int[] result;

    public static void countingSort(){
        int maxNum = max;
        countData = new int[maxNum + 1];
        result = new int[inputData.length];

        for(int i=0; i<inputData.length; i++){
            countData[inputData[i]]++;
        }

        for(int i=1; i<countData.length; i++){
            countData[i] += countData[i-1];
        }

        for(int i=inputData.length - 1; i>=0; i--){
            result[countData[inputData[i]]-1] = inputData[i];
            countData[inputData[i]]--;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine().trim());
        inputData  = new int[size];

        for(int i=0; i<inputData.length; i++){
            int num = Integer.parseInt(br.readLine().trim());
            inputData[i] = num;
            if(max < num) {
                max = num;
            }
        }

        countingSort();

        for(int output : result){
            bw.write(String.valueOf(output));
            bw.newLine();;
        }
        bw.close();
    }
}
