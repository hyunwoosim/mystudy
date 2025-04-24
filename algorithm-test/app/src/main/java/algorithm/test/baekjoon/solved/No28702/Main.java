package algorithm.test.baekjoon.solved.No28702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        for (int i = 3; i > 0; i--) {
            String s = br.readLine();
            if (s.charAt(0) != 'F' && s.charAt(0) != 'B') {
                n = Integer.parseInt(s)+ i;
                break;
            }
        }
        if( n % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if( n % 3 == 0) {
            System.out.println("Fizz");
        }else if(n % 5 == 0){
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
    }



//
//
//        for (int i = 3; i > 0; i--) {
//            String s = br.readLine();
//            if(s.matches("^[0-9]*$")) {
//                int n = Integer.parseInt(s) + i;
//
//
//                if( n % 15 == 0) {
//                    System.out.println("FizzBuzz");
//                } else if( n % 3 == 0) {
//                    System.out.println("Fizz");
//                }else if(n % 5 == 0){
//                    System.out.println("Buzz");
//                } else {
//                    System.out.println(n);
//                }
//                return;
//            }
//        }
//    }
}