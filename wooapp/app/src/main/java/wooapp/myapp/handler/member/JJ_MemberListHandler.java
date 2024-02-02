package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.Prompt;
import java.util.List;

public class JJ_MemberListHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberListHandler(JJ_MemberDao JJMemberDao, Prompt prompt) {
    super(prompt);
    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%s\n", "번호","벨트", "이름", "나이", "체급","소속","가입일");

    List<JJ_Member> list = JJMemberDao.findAll();

    for (JJ_Member member : list) {
      System.out.printf("%-4d\t%-15s\t%-15s\t%-10s\t%-10s\t%-10s\t%7$tY-%7$tm-%7$td\n",
          member.getNo(),
          member.getBelt(),
          member.getName(),
          member.getAge(),
          member.getWeight(),
          member.getTeam(),
          member.getCreatedDate());
    }
  }
}
