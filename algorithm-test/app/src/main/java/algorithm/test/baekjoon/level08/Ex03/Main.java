package algorithm.test.baekjoon.level08.Ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int q = 25;
        int d = 10;
        int n = 5;
        int p = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());

           sb.append(c/q + " ");
           c %= q;

           sb.append(c/d + " ");
           c %= d;

           sb.append(c/n + " ");
           c %= n;

           sb.append(c/p + "\n");
           c %= p;

        }
        System.out.println(sb);
    }
}
