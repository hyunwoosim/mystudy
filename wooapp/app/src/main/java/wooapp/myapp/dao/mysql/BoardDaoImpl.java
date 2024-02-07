package wooapp.myapp.dao.mysql;

import java.sql.PreparedStatement;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.dao.DaoException;
import wooapp.myapp.vo.Board;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

    int category;
    Connection con;

    public BoardDaoImpl(Connection con, int category) {
        this.con = con;
        this.category = category;
    }

    @Override
    public void add(Board board) {
        try(PreparedStatement pstmt = con.prepareStatement(
            "insert into boards(title,content,writer,category) values(?,?,?,?)")) {

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.setInt(4, board.getNo());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }
    }

    @Override
    public int delete(int no) {
        try ( PreparedStatement pstmt = con.prepareStatement(
            "delete from boards where board_no=?");){

            pstmt.setInt(1,no);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 삭제 오류", e);
        }
    }

    @Override
    public List<Board> findAll() {
        try(PreparedStatement pstmt = con.prepareStatement(
            "select board_no, title, created_date from boards where category=? order by board_no desc")) {

            ResultSet rs = pstmt.executeQuery();

            ArrayList<Board> list = new ArrayList<>();

            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("board_no"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));
                board.setCreatedDate(rs.getDate("created_date"));

                list.add(board);
            }
            return list;

        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public Board findBy(int no) {
        try(PreparedStatement pstmt = con.prepareStatement(
            "select * from boards where board_no = ?")) {

            pstmt.setInt(1,no);

          try(ResultSet rs = pstmt.executeQuery( )) {

              if (rs.next()) {
                  Board board = new Board();
                  board.setNo(rs.getInt("board_no"));
                  board.setTitle(rs.getString("title"));
                  board.setContent(rs.getString("content"));
                  board.setWriter(rs.getString("writer"));
                  board.setCreatedDate(rs.getDate("created_date"));

                  return board;
              }
              return null;
          }
        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public int update(Board board) {
        try ( PreparedStatement pstmt = con.prepareStatement(
            "update boards set title=?, content=?, writer=? where board_no=?")){

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.setInt(4, board.getNo());



            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 변경 오류", e);
        }
    }
}