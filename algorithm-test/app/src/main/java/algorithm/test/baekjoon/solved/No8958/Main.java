package algorithm.test.baekjoon.solved.No8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());

        for (int i = 0; i < A; i++) {
            String B = br.readLine();
            int count = 1;
            int result = 0;

            for(int j = 0; j < B.length(); j++){
                if(B.charAt(j) == 'O'){
                    result += count;
                    count++;
                }else{
                    count =1;
                }
            }
            bw.write(result + "\n");
            bw.flush();
        }
    }
}