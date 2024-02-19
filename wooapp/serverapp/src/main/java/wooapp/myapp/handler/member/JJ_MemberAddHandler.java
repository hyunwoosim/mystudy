package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.Prompt;
import java.util.Date;

public class JJ_MemberAddHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberAddHandler(JJ_MemberDao JJMemberDao) {

    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action( Prompt prompt) {
    JJ_Member member = new JJ_Member();
    member.setBelt(prompt.input("벨트? "));
    member.setName(prompt.input("이름? "));
    member.setAge(prompt.inputInt("나이? "));
    member.setWeight(prompt.input("체급? "));
    member.setTeam(prompt.input("소속? "));
    member.setCreatedDate(new Date());

    JJMemberDao.add(member);
  }
}
