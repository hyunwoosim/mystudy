package app.myapp.dao;

import app.myapp.vo.JJ_Member;
import java.util.List;

public interface JJ_MemberDao {

  public void add(JJ_Member JJMember);

  public int delete(int no);

  public List<JJ_Member> findAll();

  public JJ_Member findBy(int no);

  public int update(JJ_Member JJMember);

  public JJ_Member findByNameAndPassword(String name, String password);
}
