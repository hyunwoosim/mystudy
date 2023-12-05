package bitcamp.myapp;

public class AssignmentMenu {

    static void printMenu() {
        System.out.println("[과제]");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");

    }

    static void execute() {
        printMenu();
        Amd a1 = new Amd();
        while (true) {
            String input = Prompt.input("메인/과제> ");

            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    view();
                    break;
                case "3":
                    modify(a1);
                    break;
                case "4":
                    delete();
                    break;
                case "0":
                    return;
                case "menu":
                    printMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다!");
            }
        }
    }

    static void add(Amd a1) {

        System.out.println("과제 등록:");
        a1.title = Prompt.input("과제명? ");
        a1.content = Prompt.input("내용? ");
        a1.deadline = Prompt.input("제출 마감일? ");
    }

    static void view(Amd a1) {
        System.out.println("과제 조회:");
        System.out.printf("과제명: %s\n", a1.title);
        System.out.printf("내용: %s\n", a1.content);
        System.out.printf("제출 마감일: %s\n", a1.deadline);
    }

    static void modify(Amd a1) {
        System.out.println("과제 변경:");
        a1.title = Prompt.input("과제명(%s)? ", a1.title);
        a1.content = Prompt.input("내용(%s)? ", a1.content);
        a1.deadline = Prompt.input("제출 마감일(%s)? ", a1.deadline);
    }

    static void delete() {
        System.out.println("과제 삭제:");
        Amd.title = "";
        Amd.content = "";
        Amd.deadline = "";
    }

}
