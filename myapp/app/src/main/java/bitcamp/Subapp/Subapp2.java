package bitcamp.Subapp;

public class Subapp2 {


    public static void main(String[] args) {

        SubMainMenu.printMenu();

        java.util.Scanner keyIn = new java.util.Scanner(System.in);

        loop:
        while (true) {
            String input = SubPrompt.prompt("메인", keyIn);

            switch (input) {
                case "1":
                    SubAssigmentMenu.onAssigment(keyIn);

                    break;
                case "2":
                    SubBoardMenu.onBoard(keyIn);
                    break;
                case "3":
                    System.out.println("도움말입니다.");
                    break;
                case "4":
                    System.out.println("종료합니다.");
                    break loop;
                case "menu":
                    SubMainMenu.printMenu();
                    break;
                default:
                    System.out.println("옳지않은 메뉴입니다.");
                    break;
            }
        }
        keyIn.close();
    }

}
