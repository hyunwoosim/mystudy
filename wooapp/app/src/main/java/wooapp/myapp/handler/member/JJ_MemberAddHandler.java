package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.Prompt;
import java.util.Date;

public class JJ_MemberAddHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberAddHandler(JJ_MemberDao JJMemberDao, Prompt prompt) {
    super(prompt);
    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action() {
    JJ_Member member = new JJ_Member();
    member.setBelt(this.prompt.input("벨트? "));
    member.setName(this.prompt.input("이름? "));
    member.setAge(this.prompt.inputInt("나이? "));
    member.setWeight(this.prompt.input("체급? "));
    member.setTeam(this.prompt.input("소속? "));
    member.setCreatedDate(new Date());

    JJMemberDao.add(member);
  }
}
