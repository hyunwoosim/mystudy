package algorithm.test.baekjoon.level04.Ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int[] arr = new int[a];
//        for(int i = 0; i < a; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for(int j  = 0; j < arr.length; j++) {
//            if(arr[j] < b) {
//                System.out.print(arr[j] + " ");
//            }
//        }
//    }
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine(), " ");

    for(int i = 0; i < a; i++) {
        int value = Integer.parseInt(st.nextToken());

        if(value < b){
            sb.append(value).append(" ");
        }
    }
    System.out.println(sb);


}
}
