package bitcamp.myapp.Dao;

import bitcamp.myapp.vo.Board;
import java.util.List;


public class BoardDao extends AbstractDao<Board> {

    private int lastkey;

    public BoardDao(String filepath) {
        super(filepath);

        lastkey = list.getLast().getNo();
    }

    public List<Board> findAll() {
        return this.list.subList(0, list.size());
    }

    public void add(Board board) {
        board.setNo(++lastkey);
        this.list.add(board);
        saveData();
    }

    public int delete(int no) {
        int index = indexOf(no);
        if (index == -1) {
            return 0;
        }
        list.remove(index);
        saveData();
        return 1;
    }

    public Board findby(int no) {
        int index = indexOf(no);
        if (index == -1) {
            return null;
        }
        return list.get(index);
    }

    public int update(Board board) {
        int index = indexOf(board.getNo());
        if (index == -1) {
            return 0;
        }
        list.set(index, board);
        saveData();
        return 1;
    }


    private int indexOf(int no) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNo() == no) {
                return i;
            }
        }
        return -1;
    }


}



