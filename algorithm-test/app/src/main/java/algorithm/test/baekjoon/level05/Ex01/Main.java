package algorithm.test.baekjoon.level05.Ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        int i = Integer.parseInt(br.readLine())-1;

        System.out.println(st.charAt(i));
    }
}
