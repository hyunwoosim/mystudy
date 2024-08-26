package algorithm.test.baekjoon.level10.Ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] coord_1 = br.readLine().split(" ");
        String[] coord_2 = br.readLine().split(" ");
        String[] coord_3 = br.readLine().split(" ");

        String x;
        String y;
//        System.out.println(coord_1[0]+ " " + coord_1[1]);
//        System.out.println(coord_2[0]+ " " + coord_2[1]);
//        System.out.println(coord_3[0]+ " " + coord_3[1]);

        // x 좌표 비교
        // 1번 x좌표와 2번 x좌표 비교
        if (coord_1[0].equals(coord_2[0])) {
            x = coord_3[0];
//            System.out.println(1 + " : " + x);
        }

        // 1번 x좌표와 3번 x좌표 비교
        else if (coord_1[0].equals(coord_3[0])) {
            x = coord_2[0];
//            System.out.println(2 + " : " + x);
        }
        // 2번 x좌표와 3번 x좌표 비교
        else {
            x = coord_1[0];
//            System.out.println(3 + " : " + x);
        }

        // y 좌표 비교
        // 1번 x좌표와 2번 x좌표 비교
        if (coord_1[1].equals(coord_2[1])) {
            y = coord_3[1];
//            System.out.println(4 + " : " + y);
        }
        // 1번 x좌표와 3번 x좌표 비교
        else if (coord_1[1].equals(coord_3[1])) {
            y = coord_2[1];
//            System.out.println(5 + " : " + y);
        }
        // 2번 x좌표와 3번 x좌표 비교
        else {
            y = coord_1[1];
//            System.out.println(6 + " : " + y);
        }

        System.out.println(x + " " + y);
    }
}
