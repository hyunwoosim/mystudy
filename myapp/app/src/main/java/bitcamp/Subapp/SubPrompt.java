package bitcamp.Subapp;

import java.util.Scanner;

public class SubPrompt {

    static String prompt(String title, Scanner keyIn) {
        System.out.printf("%s> ", title);
        return keyIn.nextLine();
    }

}
