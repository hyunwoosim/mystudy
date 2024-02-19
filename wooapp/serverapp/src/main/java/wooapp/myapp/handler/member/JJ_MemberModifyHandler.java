package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.Prompt;


public class JJ_MemberModifyHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberModifyHandler(JJ_MemberDao JJMemberDao) {

    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action( Prompt prompt) {
    int no = prompt.inputInt("번호? ");

    JJ_Member old = JJMemberDao.findBy(no);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    JJ_Member member = new JJ_Member();
    member.setNo(old.getNo());
    member.setBelt(prompt.input("벨트(%s)? ", old.getBelt()));
    member.setName(prompt.input("이름(%s)? ", old.getName()));
    member.setName(prompt.input("나이(%s)? ", old.getAge()));
    member.setWeight(prompt.input("체급(%s)? ", old.getWeight()));
    member.setTeam(prompt.input("소속(%s)?", old.getTeam()));

    member.setCreatedDate(old.getCreatedDate());

    JJMemberDao.update(member);
    System.out.println("회원을 변경했습니다.");
  }
}
