package bitcamp.Subapp;

import java.util.Scanner;

public class SubAssigmentMenu {

    static void printAssigmentMenu() {
        System.out.println("[과제]");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }

    static void onAssigment(Scanner keyIn) {
        printAssigmentMenu();

        while (true) {
            String input = SubPrompt.prompt("메인/과제", keyIn);

            switch (input) {
                case "1":
                    System.out.println("등록입니다.");
                    break;
                case "2":
                    System.out.println("조회글입니다.");
                    break;
                case "3":
                    System.out.println("변경입니다.");
                    break;
                case "4":
                    System.out.println("삭제입니다.");
                    break;
                case "0":
                    return;
                case "menu":
                    printAssigmentMenu();
                    break;
                default:
                    System.out.println("옳지않은 메뉴입니다.");
                    break;

            }
        }
    }
}
