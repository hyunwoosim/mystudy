package wooapp.myapp.handler.board;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.vo.Board;
import wooapp.util.Prompt;
import java.util.Date;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardAddHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  protected void action( Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    boardDao.add(board);
  }
}
