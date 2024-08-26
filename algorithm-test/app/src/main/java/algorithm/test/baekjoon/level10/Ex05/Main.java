package algorithm.test.baekjoon.level10.Ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int x_min = 10000;
        int x_max = -10000;
        int y_min = 10000;
        int y_max = -10000;

        if(N != 1) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x_max < x) {
                    x_max = x;
                }
                if (x_min > x) {
                    x_min = x;
                }
                if (y_max < y) {
                    y_max = y;
                }
                if (y_min > y) {
                    y_min = y;
                }
            }
            int x = x_max - x_min;
            int y = y_max - y_min;

            System.out.println(x * y);
        } else {
            System.out.println(0);
        }

    }
}
