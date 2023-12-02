package bitcamp.Subapp;

public class SubMainMenu {


    static final String ANSI_CLEAR = "\033[0m";
    static final String ANSI_BOLD_RED = "\033[1;31m";
    static final String ANSI_RED = "\033[0;31m";
    static final String APP_TITLE = "[과제관리 시스템]";
    static final String[] menus = {
        "1. 과제",
        "2. 게시글",
        "3. 도움말",
        ANSI_RED + "4. 종료" + ANSI_CLEAR
    };

    static void printMenu() {
        System.out.println(APP_TITLE);
        System.out.println();
        for (String menu : menus) {
            System.out.println(menu);
        }
    }


}


