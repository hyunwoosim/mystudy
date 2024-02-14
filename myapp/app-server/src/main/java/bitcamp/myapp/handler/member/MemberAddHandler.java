package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManger;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

    private TransactionManger txManager;
    private MemberDao memberDao;

    public MemberAddHandler(TransactionManger txManager, MemberDao memberDao) {
        this.txManager = txManager;
        this.memberDao = memberDao;
    }

    @Override
    protected void action(Prompt prompt) {

        try {
            txManager.startTransaction();

            Member member = new Member();
            member.setEmail(prompt.input("이메일? "));
            member.setName(prompt.input("이름? "));
            member.setPassword(prompt.input("암호? "));
            member.setCreatedDate(new Date());

            memberDao.add(member);

        } catch (Exception e) {
            prompt.println("등록 오류!");

        }
    }
}
