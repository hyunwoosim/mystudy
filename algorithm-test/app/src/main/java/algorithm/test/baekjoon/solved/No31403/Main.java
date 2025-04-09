package algorithm.test.baekjoon.solved.No31403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int sum = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);


        String abSum = a + b;

        int result = Integer.parseInt(abSum) - Integer.parseInt(c);

        System.out.println(sum);
        System.out.println(result);


    }

}