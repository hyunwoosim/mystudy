package app.myapp.dao.mysql;

import java.sql.PreparedStatement;
import app.myapp.dao.DaoException;
import app.myapp.dao.JJ_MemberDao;
import app.myapp.vo.JJ_Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import app.util.DBConnectionPool;

public class JJMemberDaoImpl implements JJ_MemberDao {

DBConnectionPool connectionPool;

  public JJMemberDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(JJ_Member member) {

      try
        (Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "insert into jjmember(belt,name,age,weight,team,password) values('?','?','?','?','?',sha2(?,256))"
           )){
            pstmt.setString(1, member.getBelt());
        pstmt.setString(2, member.getName());
        pstmt.setInt(3, member.getAge());
        pstmt.setString(4, member.getWeight());
        pstmt.setString(5, member.getTeam());
        pstmt.setString(3, member.getPassword());
      pstmt.executeUpdate();

    }
    catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {

      try ( Connection con = connectionPool.getConnection();
          PreparedStatement pstmt = con.prepareStatement(
          "delete from jjmember where no=%d", no)) {
        pstmt.setInt(1, no);
     return pstmt.executeUpdate();


      } catch (Exception e) {
        throw new DaoException("데이터 삭제 오류", e);
      }
    }


  @Override
  public List<JJ_Member> findAll() {

      try ( Connection con = connectionPool.getConnection();
          PreparedStatement pstmt = con.prepareStatement(
          "select * from jjmember");
          ResultSet rs = pstmt.executeQuery();) {

        ArrayList<JJ_Member> list = new ArrayList<>();

        while (rs.next()) {
          JJ_Member member = new JJ_Member();
          member.setNo(rs.getInt("no"));
          member.setBelt(rs.getString("belt"));
          member.setName(rs.getString("name"));
          member.setAge(rs.getInt("age"));
          member.setWeight(rs.getString("weight"));
          member.setTeam(rs.getString("team"));
          member.setCreatedDate(rs.getDate("jd"));

          list.add(member);
        }
        return list;

      } catch (Exception e) {
        throw new DaoException("데이터 가져오기 오류", e);
      }
    }


  @Override
  public JJ_Member findBy(int no) {

        try (Connection con = connectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(
            "select * from jjmember where no = " + no)) {
          pstmt.setInt(1, no);

          try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
              JJ_Member member = new JJ_Member();
              member.setNo(rs.getInt("no"));
              member.setBelt(rs.getString("belt"));
              member.setName(rs.getString("name"));
              member.setAge(rs.getInt("age"));
              member.setWeight(rs.getString("weight"));
              member.setTeam(rs.getString("team"));
              member.setCreatedDate(rs.getDate("jd"));

              return member;
            }
          }
          return null;

        } catch (Exception e) {
          throw new DaoException("데이터 가져오기 오류", e);

  }}

  @Override
  public int update(JJ_Member member) {
        String sql = null;
        if(member.getPassword().length() == 0) {
        sql = "\"update jjmember set belt='?', name='?', age='?', weight='?', team='?' where member_no=?";
        }else{
          sql = "update jjmember set belt='?', name='?', age='?', weight='?', team='?', password=sha2(?,256) where member_no=?";
          }


      try ( Connection con = connectionPool.getConnection();
          PreparedStatement pstmt = con.prepareStatement(sql)){
        pstmt.setString(1, member.getBelt());
        pstmt.setString(2, member.getName());
        pstmt.setInt(3, member.getAge());
        pstmt.setString(4, member.getWeight());
        pstmt.setString(5, member.getTeam());
        pstmt.setString(3, member.getPassword());
        pstmt.setInt(6, member.getNo());
       return pstmt.executeUpdate();


    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  @Override
  public JJ_Member findByNameAndPassword(String name, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select member_no, name, team, created_date from members where name=? and password=sha2(?,256)")) {
      pstmt.setString(1, name);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          JJ_Member member = new JJ_Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          member.setTeam(rs.getString("team"));
          member.setCreatedDate(rs.getDate("created_date"));
          return member;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

}
