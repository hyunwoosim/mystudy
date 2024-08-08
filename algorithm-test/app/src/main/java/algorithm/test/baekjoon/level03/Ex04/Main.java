package algorithm.test.baekjoon.level03.Ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int num =  Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
           sum += A * B;
        }

        if(total == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
