package wooapp.myapp.dao.mysql;

import java.sql.PreparedStatement;
import wooapp.myapp.dao.DaoException;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import wooapp.util.ThreadConnection;

public class JJMemberDaoImpl implements JJ_MemberDao {

ThreadConnection threadConnection;

  public JJMemberDaoImpl(ThreadConnection threadConnection) {
    this.threadConnection = threadConnection;
  }

  @Override
  public void add(JJ_Member member) {
    Connection con = null;
    try {
      con = threadConnection.get();
      try
        (PreparedStatement pstmt = con.prepareStatement(
            "insert into jjmember(belt,name,age,weight,team) values('?','?','?','?','?')"
           )){
            pstmt.setString(1, member.getBelt());
        pstmt.setString(2, member.getName());
        pstmt.setInt(3, member.getAge());
        pstmt.setString(4, member.getWeight());
        pstmt.setString(5, member.getTeam());
      pstmt.executeUpdate();
      }
    }
    catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    Connection con = null;
    try {
      con = threadConnection.get();

      try (PreparedStatement pstmt = con.prepareStatement(
          "delete from jjmember where no=%d", no)) {
        pstmt.setInt(1, no);
     return pstmt.executeUpdate();
      }

      } catch (Exception e) {
        throw new DaoException("데이터 삭제 오류", e);
      }
    }


  @Override
  public List<JJ_Member> findAll() {
    Connection con = null;
    try {
      con = threadConnection.get();

      try (PreparedStatement pstmt = con.prepareStatement(
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
      }
      } catch (Exception e) {
        throw new DaoException("데이터 가져오기 오류", e);
      }
    }


  @Override
  public JJ_Member findBy(int no) {

    Connection con = null;
    try {
      con = threadConnection.get();

        try (PreparedStatement pstmt = con.prepareStatement(
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
        }
        } catch (Exception e) {
          throw new DaoException("데이터 가져오기 오류", e);

  }}

  @Override
  public int update(JJ_Member member) {

      Connection con = null;
      try {
        con = threadConnection.get();


      try (PreparedStatement pstmt = con.prepareStatement(
          "update jjmember set belt='?', name='?', age='?', weight='?', team='?' where no=?")) {
        pstmt.setString(1, member.getBelt());
        pstmt.setString(2, member.getName());
        pstmt.setInt(3, member.getAge());
        pstmt.setString(4, member.getWeight());
        pstmt.setString(5, member.getTeam());
        pstmt.setInt(6, member.getNo());
       return pstmt.executeUpdate();
      }

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
