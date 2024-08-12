package algorithm.test.baekjoon.level04.Ex05;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st. nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int q = Integer.parseInt(st.nextToken()); // 시작 바구니
            int w = Integer.parseInt(st.nextToken()); // 끝 바구니
            int e = Integer.parseInt(st.nextToken()); // 공 번호

            for(int j = q-1; j < w;  j++){
                arr[j] = e;
            }
        }

        for(int i = 0; i < arr.length; i++){
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.flush();
        br.close();
    }
}
