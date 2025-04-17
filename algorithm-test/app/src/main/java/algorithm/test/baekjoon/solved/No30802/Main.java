package algorithm.test.baekjoon.solved.No30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] size = new int[6];
        for(int i = 0; i < 6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        Arrays.sort(size);
        for (int i : size) {
            count += i / T;
            count = i % T > 0 ? count + 1 : count;
        }

        int temp = N/P;
        int temp2 = N%P;

        System.out.println(count);
        System.out.println(temp + " " + temp2);

    }

}