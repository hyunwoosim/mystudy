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
import app.myapp.vo.JJ_Member;
import app.util.DBConnectionPool;

@WebServlet("/jjmember/view")
public class JJ_MemberViewServlet extends HttpServlet {

  private JJ_MemberDao memberDao;

  public JJ_MemberViewServlet() {
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

try{
    int no = Integer.parseInt(request.getParameter("no"));

    JJ_Member member = memberDao.findBy(no);
    if (member == null) {
      out.println("<p>회원 번호가 유효하지 않습니다.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

  out.println("<form action='/member/update'>");
  out.println("<div>");
  out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", member.getNo());
  out.println("</div>");
  out.println("<div>");
  out.printf("  벨트: <input readonly name='belt' type='text' value='%s'>\n", member.getBelt());
  out.println("</div>");
  out.println("<div>");
  out.printf("  이름: <input name='name' type='text' value='%s'>\n", member.getName());
  out.println("</div>");
  out.println("<div>");
  out.println("  암호: <input name='password' type='password'>");
  out.println("</div>");
  out.println("<div>");
  out.printf("  나이: <input readonly name='age' type='text' value='%d'>\n", member.getAge());
  out.println("</div>");
  out.println("<div>");
  out.printf("  체급: <input readonly name='weight' type='text' value='%s'>\n", member.getWeight());
  out.println("</div>");
  out.println("<div>");
  out.printf("  소속: <input readonly name='team' type='text' value='%s'>\n", member.getTeam());
  out.println("</div>");
  out.println("<div>");
  out.printf("  가입일: <input readonly type='text' value='%s'>\n", member.getCreatedDate());
  out.println("</div>");
  out.println("<div>");
  out.println("  <button>변경</button>");
  out.printf("  <a href='/member/delete?no=%d'>[삭제]</a>\n", no);
  out.println("</div>");
  out.println("</form>");

  }catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");


  }
}
