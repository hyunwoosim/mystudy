package algorithm.test.baekjoon.level06.Ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        StringBuilder sb = new StringBuilder(A);

        if(A.equals(sb.reverse().toString())) {
//            System.out.println("1");
            bw.write("1");
        }else {
//            System.out.println("0");
            bw.write("0");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
