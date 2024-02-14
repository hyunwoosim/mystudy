package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManger;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;
    private TransactionManger txManager;

    public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao,
        TransactionManger txManager) {
        this.boardDao = boardDao;
        this.attachedFileDao = attachedFileDao;
        this.txManager = txManager;
    }

    @Override
    protected void action(Prompt prompt) {

        try {

            int no = prompt.inputInt("번호? ");

            Board oldBoard = boardDao.findBy(no);
            if (oldBoard == null) {
                prompt.println("게시글 번호가 유효하지 않습니다.");
                return;
            }

            Board board = new Board();
            board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
            board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
            board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
            board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
            board.setCreatedDate(oldBoard.getCreatedDate());

            prompt.println("[첨부파일]");

            List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

            while (true) {
                int subMenu = prompt.inputInt("추가(1), 삭제(2), 변경없음(0)? ");

                if (subMenu == 0) {
                    System.out.println("변경없음");
                    break;

                } else if (subMenu == 1) {
                    while (true) {
                        String filepath = prompt.input("파일 추가?(종료: 그냥 엔터)");
                        if (filepath.length() == 0) {
                            break;
                        }
                        files.add(new AttachedFile().filePath(filepath));
                    }
                    try {
                        txManager.startTransaction();

                        if (files.size() > 0) {
                            //첨부파일 객체에 게시글 번호 저장
                            for (AttachedFile file : files) {
                                file.setBoardNo(board.getNo());
                            }
                            attachedFileDao.addAll(files);
                        }

                        txManager.commit();

                    } catch (Exception e) {
                        try {
                            txManager.rollback();
                        } catch (Exception e2) {
                        }
                        prompt.println("첨부파일 등록 오류!");
                    }


                } else if (subMenu == 2) {
                    List<AttachedFile> attaches = attachedFileDao.findAllByFileNo(no);
                    prompt.println("첨부파일: ");
                    for (AttachedFile attach : attaches) {
                        prompt.printf("  %s(%d)\n", attach.getFilePath(), attach.getNo());
                    }
                    no = prompt.inputInt("번호? ");
                    if (attachedFileDao.delete(no) == 0) {
                        prompt.println("첨부 파일 번호가 유효하지 않습니다.");
                    } else {
                        prompt.println("삭제했습니다!");
                    }

                }
            }

            boardDao.update(board);
            System.out.println("게시글을 변경했습니다.");

        } catch (Exception e) {
            prompt.println("변경 오류!");

            /*
            [변경]
            번호? 1
            제목(제목1)? 제목1
            내용(내용1)? 내용1
            작성자(홍길동)? 홍길동
            첨부파일 추가(1) 삭제(2)? 1
            "파일?(종료: 그냥 엔터)"

            ex)"삭제?(종료 : 그냥 엔터)"
                a1.gif(1)
                a2.gif(2)
                a3.gif(3)
                첨부파일 삭제번호?

             */

        }
    }
}
