package algorithm.test.baekjoon.level04.Ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        Arrays.sort(arr);
        // 작은 값부터 정렬

        for(int i = 0; i < arr.length; i++) {
            sum += ((arr[i]/arr[arr.length-1]) * 100);
        }
        System.out.print(sum/ arr.length);

    }
}
