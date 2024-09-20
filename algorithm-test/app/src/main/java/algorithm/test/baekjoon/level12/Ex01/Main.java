package algorithm.test.baekjoon.level12.Ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, n, m);
        System.out.println(result);
    }

    private static int search(int[] arr, int n, int m) {
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > m) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] + arr[j] > m) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];

                    if (temp == m) {
                        return temp;
                    }

                    if (result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }


        return result;
    }

}
