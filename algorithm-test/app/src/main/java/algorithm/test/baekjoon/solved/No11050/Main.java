package algorithm.test.baekjoon.solved.No11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        System.out.println(binomial(N, K));

    }

    static int binomial(int N, int K) {
        if(K > N - K) {
            K = N - K;
        }

        int result = 1;
        for(int i = 1; i <= K; i++) {
            result *= (N - i + 1);
            result /= i;
        }

        return result;
    }


}