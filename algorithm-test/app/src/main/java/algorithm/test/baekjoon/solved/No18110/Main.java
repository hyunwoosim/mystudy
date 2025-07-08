package algorithm.test.baekjoon.solved.No18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);

        int cut = (int) Math.round(n * 0.15);

        long sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += scores[i];
        }

        int count = n - 2 * cut;

        System.out.println(Math.round((double)sum / count));
    }
}