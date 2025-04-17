package algorithm.test.baekjoon.solved.No4153;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0) {
                break;
            }

            int[] arr = {A, B, C};
            Arrays.sort(arr);
            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();

    }

}