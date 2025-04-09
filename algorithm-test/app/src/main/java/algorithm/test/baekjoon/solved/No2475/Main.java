package algorithm.test.baekjoon.solved.No2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
          방법 1
         */
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = 0;

        for(int i = 0; i <= 4; i++ ) {
            int n = Integer.parseInt(st.nextToken());

            temp += n* n;
        }
        System.out.println(temp%10);

        /*
          방법 2
         */
//
//        int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(n -> n * n).sum();
//
//        System.out.println(sum % 10);
    }
}