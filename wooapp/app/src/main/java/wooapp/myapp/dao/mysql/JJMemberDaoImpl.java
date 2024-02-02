package wooapp.myapp.dao.mysql;

import wooapp.myapp.dao.DaoException;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.vo.JJ_Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JJMemberDaoImpl implements JJ_MemberDao {

  Connection con;

  public JJMemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(JJ_Member member) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into jjmember(belt,name,age,weight,team) values('%s','%s','%s','%s','%s')",
          member.getBelt(), member.getName(), member.getAge(),member.getWeight(),
          (member.getTeam().length() > 0) ? member.getTeam(): "무소속"));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from jjmember where no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<JJ_Member> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from jjmember");

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
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from jjmember where no = " + no);

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
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(JJ_Member member) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update jjmember set belt='%s', name='%s', age='%s', weight='%s', team='%s' where no=%d",
          member.getBelt(), member.getName(), member.getAge(),member.getWeight(),
          (member.getTeam().length() > 0) ? member.getTeam(): "무소속"
          , member.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
