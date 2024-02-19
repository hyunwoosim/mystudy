package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.Prompt;

public class JJ_MemberViewHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberViewHandler(JJ_MemberDao JJMemberDao) {

    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action( Prompt prompt) {
    int no = prompt.inputInt("번호? ");

    JJ_Member member = JJMemberDao.findBy(no);
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    System.out.printf("번호: %d\n", member.getNo());
    System.out.printf("벨트: %s\n", member.getBelt());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("나이: %s\n", member.getAge());
    System.out.printf("체급: %s\n", member.getWeight());
    System.out.printf("소속: %s\n", member.getTeam());
    System.out.printf("가입일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", member.getCreatedDate());
  }
}
