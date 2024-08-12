package algorithm.test.baekjoon.level04.Ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 바구니 갯수
        int M = Integer.parseInt(st.nextToken()); //
        int num = 0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int q = Integer.parseInt(st.nextToken()); // q번 바구니
            int w = Integer.parseInt(st.nextToken()); // w번 바구니

            num = arr[q-1];
            arr[q-1] = arr[w-1];
            arr[w-1] = num;
        }
        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
