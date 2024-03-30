package app.myapp.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.myapp.dao.JJ_MemberDao;
import app.myapp.dao.mysql.JJMemberDaoImpl;
import app.myapp.vo.JJ_Member;
import app.util.DBConnectionPool;

@WebServlet("/auth/login")
public class LoginServlet extends GenericServlet {

        JJ_MemberDao memberDao;

        public LoginServlet() {
            DBConnectionPool connectionPool = new DBConnectionPool(
                "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
            this.memberDao = new JJMemberDaoImpl(connectionPool);
        }

        @Override
        public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

            // 서블릿 컨테이너가 service()를 호출할 때 넘겨주는 값을
            // HttpServletRequest와 HttpServletResponse이다.
            // 파라미터로 넘어 온 객체를 제대로 사용하고 싶다면 원래 타입으로 형변환하라!
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            String name = request.getParameter("name");
            String password = request.getParameter("password");

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("  <meta charset='UTF-8'>");
            out.println("  <title>비트캠프 데브옵스 5기</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>과제 관리 시스템</h1>");
            out.println("<h2>로그인</h2>");

            try {
                JJ_Member member = memberDao.findByNameAndPassword(name, password);
                if (member != null) {
                    request.getSession().setAttribute("loginUser", member);
                    out.printf("<p>%s 님 환영합니다.</p>\n", member.getName());
                    response.setHeader("Refresh","1;url=/index.html");
                } else {
                    out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
                    response.setHeader("Refresh","1;url=/auth/form.html");
                }
            } catch (Exception e) {
                out.println("<p>로그인 오류!</p>");
                out.println("<pre>");
                e.printStackTrace(out);
                out.println("</pre>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }


