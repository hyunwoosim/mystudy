package algorithm.test.baekjoon.level04.Ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 1000001;
        int max = -1000001;

        for(int i = 0 ; i < a; i++){
            int value = Integer.parseInt(st.nextToken());

            if(value > max) {
                max = value;
            }
            if(value < min) {
                min = value;
            }
        }
        System.out.print(min + " " + max);
    }

}
