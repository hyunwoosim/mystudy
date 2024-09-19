package algorithm.test.baekjoon.level11.Ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        br.close();

        bw.write((n*(n-1)*(n-2)/6)+"\n" + 3);
        bw.flush();
        bw.close();

    }

//        int count = 0;
//
//        for (int i = 1; i <= n - 2; i++) {
//            for (int j = i + 1; j <= n - 1; j++) {
//                for(int k = j+1; k <= n; k++) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
}
