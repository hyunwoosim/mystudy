package wooapp.myapp.handler.assignment;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.AssignmentDao;
import wooapp.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  public AssignmentDeleteHandler(AssignmentDao assignmentDao) {

    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");
      if (assignmentDao.delete(no) == 0) {
        System.out.println("과제 번호가 유효하지 않습니다!");
      } else {
        System.out.println("과제를 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}
