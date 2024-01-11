package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.Dao.MemberDao;
import bitcamp.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

    private MemberDao memberDao;

    public MemberDeleteHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        int no = this.prompt.inputInt("번호? ");
        if (memberDao.delete(no) == 0) {
            System.out.println("회원 번호가 유효하지 않습니다!");
        } else {
            System.out.println("삭제 완료");
        }
    }
}
