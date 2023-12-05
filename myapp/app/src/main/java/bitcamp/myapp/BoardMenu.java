package bitcamp.myapp;

public class BoardMenu {

    static String title;
    static String content;
    static String wirter;
    static String date;


    static void printMenu() {
        System.out.println("[게시글]");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }


    static void execute() {
        printMenu();

        loop2:
        while (true) {
            String input = Prompt.input("메인/게시글> ");

            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    content();
                    break;
                case "3":
                    writer();
                    break;
                case "4":
                    date();
                    break;
                case "0":
                    break loop2;
                case "menu":
                    printMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다!");
            }
        }
    }

    static void add() {
        System.out.println("게시글 제목: ");
        title = Prompt.input("제목? ");
        content = Prompt.input("내용? ");
        wirter = Prompt.input("작성자? ");
        date = Prompt.input("작성일 ");

    }

    static void content() {
        System.out.println("게시글 조회: ");
        System.out.printf("제목 %s\n", title);
        System.out.printf("내용 %s\n", content);
        System.out.printf("작성자 %s\n", wirter);
        System.out.printf("작성일 %s\n", date);

    }

    static void writer() {
        System.out.println("게시글 변경: ");
        title = Prompt.input("제목(%s)?", title);
        content = Prompt.input("내용(%s)?", content);
        wirter = Prompt.input("작성자(%s)?", wirter);
        date = Prompt.input("작성일(%s)?", date);
    }

    static void date() {
        System.out.println("게시글 삭제: ");
        title = "";
        content = "";
        wirter = "";
        date = "";

    }
}
