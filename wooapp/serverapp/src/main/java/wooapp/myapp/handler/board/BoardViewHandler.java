package wooapp.myapp.handler.board;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.vo.Board;
import wooapp.util.Prompt;

public class BoardViewHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardViewHandler(BoardDao boardDao) {

    this.boardDao = boardDao;
  }

  @Override
  protected void action( Prompt prompt) {
    int no = prompt.inputInt("번호? ");

    Board board = boardDao.findBy(no);
    if (board == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
  }
}
