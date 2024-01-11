package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.Dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

    private MemberDao memberDao;

    public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
        super(prompt);
        this.memberDao = memberDao;
    }

    @Override
    protected void action() {
        int no = this.prompt.inputInt("번호? ");

        Member old = memberDao.findby(no);
        if (old == null) {
            System.out.println("번호가 유효하지 않습니다!");
        }

        Member member = new Member();
        member.setNo(old.getNo());
        member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
        member.setName(this.prompt.input("이름(%s)? ", old.getName()));
        member.setPassword(this.prompt.input("새 암호? "));
        member.setCreatedDate(old.getCreatedDate());

        memberDao.update(member);
        System.out.println("변경 완료!");
    }
}
