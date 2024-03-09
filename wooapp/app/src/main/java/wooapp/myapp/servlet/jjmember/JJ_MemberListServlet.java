package wooapp.myapp.servlet.jjmember;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wooapp.myapp.dao.JJ_MemberDao;
import wooapp.myapp.dao.mysql.JJMemberDaoImpl;
import wooapp.myapp.vo.JJ_Member;
import wooapp.util.DBConnectionPool;

@WebServlet("/jjmember/list")
public class JJ_MemberListServlet extends HttpServlet {

  private JJ_MemberDao memberDao;

  public JJ_MemberListServlet() {

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
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    out.println("<a href='/member/form.html'>새 회원</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>벨트</th> <th>이름</th> <th>나이</th> <th>체급</th> <th>소속</th> <th>가입일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<JJ_Member> list = memberDao.findAll();

      for (JJ_Member member : list) {
        out.printf(
            "<tr> <td>%d</td> <td>%s</td>  <td><a href='/member/view?no=%1$d'>%s</a></td> <td>%d</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>\n",
            member.getNo(),
            member.getBelt(),
            member.getName(),
            member.getAge(),
            member.getWeight(),
            member.getTeam(),
            member.getCreatedDate());


    }
      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
