package algorithm.test.baekjoon.level04.Ex01;

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

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){

          A[i] = Integer.parseInt(st.nextToken());

        }

        int C = Integer.parseInt(br.readLine());


        for(int i =0; i< A.length; i++) {
            if(A[i] == C){
                cnt++;
            }
        }
        System.out.print(cnt);

        br.close();
        bw.flush();
        bw.close();
    }

}
