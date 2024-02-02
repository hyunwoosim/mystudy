package wooapp.myapp.handler.member;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.util.Prompt;

public class JJ_MemberDeleteHandler extends AbstractMenuHandler {

  private JJ_MemberDao JJMemberDao;

  public JJ_MemberDeleteHandler(JJ_MemberDao JJMemberDao, Prompt prompt) {
    super(prompt);
    this.JJMemberDao = JJMemberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (JJMemberDao.delete(no) == -1) {
      System.out.println("회원 번호가 유효하지 않습니다!");
    } else {
      System.out.println("회원을 삭제했습니다.");
    }
  }
}
