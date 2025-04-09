package algorithm.test.baekjoon.solved.No2741;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        /*
        방법 1: Scanner 사용
        */

//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for (int i =0; i <N; i++ ){
//            System.out.println((i+1));
//        }

        /*
        방법 2: br,bw 사용
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int i = 1;

        while (i <= N) {
            bw.write(i + "\n");
            i++;
        }
        bw.flush();
        bw.close();


    }
}