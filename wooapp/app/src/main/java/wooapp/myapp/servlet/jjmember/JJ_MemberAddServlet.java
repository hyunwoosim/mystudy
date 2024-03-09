package wooapp.myapp.servlet.jjmember;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.dao.mysql.JJMemberDaoImpl;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.DBConnectionPool;

@WebServlet("/jjmember/add")
public class JJ_MemberAddServlet extends HttpServlet {

  private JJ_MemberDao memberDao;

  public JJ_MemberAddServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new JJMemberDaoImpl(connectionPool);

  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>주짓수 시스템 관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");




    try {
      JJ_Member member = new JJ_Member();
      member.setBelt(request.getParameter("belt"));
      member.setName(request.getParameter("name"));
      member.setAge((Integer.parseInt(request.getParameter("age"))));
      member.setWeight(request.getParameter("weight"));
      member.setPassword(request.getParameter("password"));
      member.setTeam(request.getParameter("team"));
      member.setCreatedDate(new Date());


      memberDao.add(member);
      out.println("<p>회원을 등록했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>회원등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

