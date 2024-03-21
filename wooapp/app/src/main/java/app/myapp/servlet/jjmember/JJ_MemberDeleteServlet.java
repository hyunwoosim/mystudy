package app.myapp.servlet.jjmember;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.myapp.dao.JJ_MemberDao;
import app.myapp.dao.mysql.JJMemberDaoImpl;
import app.util.DBConnectionPool;
@WebServlet("/jjmember/delete")
public class JJ_MemberDeleteServlet extends HttpServlet {

  private JJ_MemberDao memberDao;

  public JJ_MemberDeleteServlet() {

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

      if (memberDao.delete(no) == -1) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
      } else {
        out.println("<p>회원을 삭제했습니다.</p>");
      }

    } catch (Exception e) {
      out.println("<p>삭제 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
  }

