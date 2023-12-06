package bitcamp.myapp;

public class MemberMenu {

    static Member[] members = new Member[3];
    static int length = 0;


    static void printMenu() {
        System.out.println("[회원]");
        System.out.println("1. 입력");
        System.out.println("2. 조회");
        System.out.println("3. 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }

    static void execute() {
        printMenu();

        loop:
        while (true) {
            String input = Prompt.input("메인/회원> ");

            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    view();
                    break;
                case "3":
                    modify();
                    break;
                case "4":
                    delete();
                    break;
                case "0":
                    break loop;
                case "menu":
                    printMenu();
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }

    }

    static void add() {
        System.out.println("회원 입력: ");

        Member member = new Member();

        member.name = Prompt.input("이름? ", member.name);
        member.email = Prompt.input("이메일? ", member.email);
        member.password = Prompt.input("암호? ", member.password);
        member.joinDate = Prompt.input("가입일? ", member.joinDate);

        members[length] = member;
        length++;


    }

    static void view() {
        System.out.println("회원 조회: ");

        int index = Integer.parseInt(Prompt.input("번호 ?"));
        if (index < 0 || index >= length) {
            System.out.println("회원 번호가 옳지 않습니다.");
            return;
        }

        Member member = members[index];
        System.out.printf("회원이름: %s\n ", member.name);
        System.out.printf("회원이메일: %s\n ", member.email);
        System.out.printf("회원암호: %s\n ", member.password);
        System.out.printf("회원가입일: %s\n ", member.joinDate);

    }

    static void modify() {
        System.out.println("회원 변경: ");

        Member member = new Member();
        member.name = Prompt.input("회원 이름? %s\n", member.name);
        member.email = Prompt.input("회원 이메일? %s\n", member.email);
        member.password = Prompt.input("회원 암호? %s\n", member.password);
        member.joinDate = Prompt.input("회원 가입일? %s\n", member.joinDate);
    }

    static void delete() {
        System.out.println("회원 삭제: ");

        Member member = new Member();
        member.name = "";
        member.email = "";
        member.password = "";
        member.joinDate = "";
    }
}
