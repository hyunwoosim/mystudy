package wooapp.myapp.handler.board;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.BoardDao;
import wooapp.util.Prompt;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardDeleteHandler(BoardDao boardDao) {

    this.boardDao = boardDao;
  }

  @Override
  protected void action( Prompt prompt) {
    int no = prompt.inputInt("번호? ");
    if (boardDao.delete(no) == 0) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
