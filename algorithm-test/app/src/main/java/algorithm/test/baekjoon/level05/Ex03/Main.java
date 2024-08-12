package algorithm.test.baekjoon.level05.Ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i< n; i++) {
            String st = br.readLine();
            bw.write(st.substring(0, 1) + st.substring(st.length()-1, st.length()) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

}
