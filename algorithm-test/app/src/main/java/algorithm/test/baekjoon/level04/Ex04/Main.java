package algorithm.test.baekjoon.level04.Ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int max = 1;
        for(int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());
            if(max < value){
                max = value;
                cnt = i+1;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }

}
