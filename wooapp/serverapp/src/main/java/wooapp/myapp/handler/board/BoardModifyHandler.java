package wooapp.myapp.handler.board;

import wooapp.menu.AbstractMenuHandler;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.vo.Board;
import wooapp.util.Prompt;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardModifyHandler(BoardDao boardDao) {

    this.boardDao = boardDao;
  }

  @Override
  protected void action( Prompt prompt) {
    int no = prompt.inputInt("번호? ");

    Board oldBoard = boardDao.findBy(no);
    if (oldBoard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = new Board();
    board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
    board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
    board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
    board.setCreatedDate(oldBoard.getCreatedDate());

    boardDao.update(board);
    System.out.println("게시글을 변경했습니다.");
  }
}
