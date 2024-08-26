package algorithm.test.baekjoon.level10.Ex07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if( A == 0 && B == 0 && C == 0 ) {
                break;
            } else {

                if (A >=B + C || B >= A + C || C >= A + B) {
                    // 삼각형의 조건에 만족하지 못한 경우
                    System.out.println("Invalid");
                } else {
                    if (A == B && A == C) {
                        // 세 변의 길이가 모두 같을 때
                        System.out.println("Equilateral");
                    } else if (A == B || A == C || B == C) {
                        // 두 변의 길이만 같을 때
                        System.out.println("Isosceles");
                    } else {
                        // 길이가 모두 다를 때
                        System.out.println("Scalene");
                    }
                }
            }

        }
    }
}
