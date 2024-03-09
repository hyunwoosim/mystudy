package wooapp.myapp.servlet.jjmember;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.dao.mysql.JJMemberDaoImpl;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.DBConnectionPool;

@WebServlet("/jjmember/update")
public class JJ_MemberUpdateServlet extends HttpServlet {

  private JJ_MemberDao memberDao;

  public JJ_MemberUpdateServlet() {

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
    out.println("  <title>주짓수 관리 시스템</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");


    try {
      int no = Integer.parseInt(request.getParameter("no"));

      JJ_Member old = memberDao.findBy(no);
      if (old == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }


        JJ_Member member = new JJ_Member();
        member.setNo(old.getNo());
        member.setBelt(request.getParameter("belt? "));
        member.setName(request.getParameter("name "));
        member.setName(request.getParameter("age "));
        member.setWeight(request.getParameter("weight "));
      member.setPassword(request.getParameter("password"));
        member.setTeam(request.getParameter("team"));

        memberDao.update(member);
      }catch (Exception e) {
        out.println("<p>회원 변경 오류!</p>");
        out.println("<pre>");
        e.printStackTrace(out);
        out.println("</pre>");
      }

      out.println("</body>");
      out.println("</html>");

  }
}
