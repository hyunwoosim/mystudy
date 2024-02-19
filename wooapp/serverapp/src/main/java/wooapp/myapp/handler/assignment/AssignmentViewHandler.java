package wooapp.myapp.handler.assignment;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.AssignmentDao;
import wooapp.myapp.vo.Assignment;
import wooapp.util.Prompt;

public class AssignmentViewHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  public AssignmentViewHandler(AssignmentDao assignmentDao) {

    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action( Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");
      Assignment assignment = assignmentDao.findBy(no);
      if (assignment == null) {
        System.out.println("과제 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", assignment.getNo());
      System.out.printf("과제명: %s\n", assignment.getTitle());
      System.out.printf("내용: %s\n", assignment.getContent());
      System.out.printf("제출 마감일: %s\n", assignment.getDeadline());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
