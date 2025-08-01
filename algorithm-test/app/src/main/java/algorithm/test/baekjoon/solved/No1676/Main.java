package algorithm.test.baekjoon.solved.No1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int count = 0;
        for(int i = 5; i <= N ; i *= 5 ) {
            count += N / i;
        }
        System.out.println(count);
    }
}