package wooapp.myapp.handler.board;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.vo.Board;
import wooapp.util.Prompt;
import java.util.List;

public class BoardListHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardListHandler(BoardDao boardDao) {

    this.boardDao = boardDao;
  }

  @Override
  protected void action( Prompt prompt) {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Writer", "Date");

    List<Board> list = boardDao.findAll();

    for (Board board : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getCreatedDate());
    }
  }
}
