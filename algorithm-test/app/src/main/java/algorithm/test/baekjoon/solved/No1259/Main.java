package algorithm.test.baekjoon.solved.No1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("0")){
            String reversed = new StringBuilder(input).reverse().toString();
            System.out.println(input.equals(reversed) ? "yes" : "no");
        }
    }
}