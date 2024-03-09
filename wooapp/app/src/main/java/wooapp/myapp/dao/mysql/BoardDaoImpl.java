package wooapp.myapp.dao.mysql;


import java.sql.PreparedStatement;
import wooapp.myapp.dao.BoardDao;
import wooapp.myapp.dao.DaoException;
import wooapp.myapp.vo.Board;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.DBConnectionPool;


public class BoardDaoImpl implements BoardDao {

   DBConnectionPool connectionPool;

    public BoardDaoImpl(DBConnectionPool connectionPool) {
this.connectionPool = connectionPool;
    }

    @Override
    public void add(Board board) {
        try(Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "insert into boards(title,content,writer,category) values(?,?,?,?)",
        PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getWriter().getNo());
            pstmt.setInt(4, board.getCategory());

            pstmt.executeUpdate();

            try(ResultSet keyRs = pstmt.getGeneratedKeys()) {
                keyRs.next();
                board.setNo(keyRs.getInt(1));
            }

        }
         catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }
    }

    @Override
    public int delete(int no) {

        try ( Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "delete from boards where board_no=?");) {

            pstmt.setInt(1, no);

             return pstmt.executeUpdate();
        }
         catch (Exception e) {
            throw new DaoException("데이터 삭제 오류", e);
        }
    }

    @Override
    public List<Board> findAll(int category) {
        try(Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "select"
                + " b.board_no, "
                + "b.title, "
                + "b.created_date ,"
                + "count(file_no) file_count,"
                + "m.member_no,"
                + "m.name"
                + "from"
                + "boards b left outer join board_files bf on b.board_no=bf.board_no"
                + "inner join members m on b.name=m.member_no"
                + "where"
                + "b.category=?"
                + "group by"
                + "board_no"
                + " order by"
                + " board_no desc")) {

            pstmt.setInt(1, category);

            try(ResultSet rs = pstmt.executeQuery()) {

                ArrayList<Board> list = new ArrayList<>();

                while (rs.next()) {
                    Board board = new Board();
                    board.setNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setCreatedDate(rs.getDate("created_date"));
                    board.setFileCount(rs.getInt("file_count"));

                    JJ_Member writer = new JJ_Member();
                    writer.setNo(rs.getInt("member_no"));
                    writer.setName(rs.getString("name"));

                    board.setWriter(writer);

                    list.add(board);
                }
                return list;
            }
        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public Board findBy(int no) {

        try(Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
                "select"
                    + "  b.board_no,\n"
                    + "  b.title,\n"
                    + "  b.content,"
                    + "  b.created_date,\n"
                    + "  m.member_no,\n"
                    + "  m.name\n"
                    + " from "
                    + "  boards b inner join members m on b.name=m.member_no\n"
                    + " where board_no=?")) {

            pstmt.setInt(1, no);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    Board board = new Board();
                    board.setNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setCreatedDate(rs.getDate("created_date"));


                    JJ_Member writer = new JJ_Member();
                    writer.setNo(rs.getInt("member_no"));
                    writer.setName(rs.getString("name"));

                    board.setWriter(writer);


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

        try (Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "update boards set title=?, content=?, writer=? where board_no=?")) {

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getNo());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 변경 오류", e);
        }
    }
}
