package app.myapp.servlet.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.myapp.dao.AssignmentDao;
import app.myapp.dao.mysql.AssignmentDaoImpl;
import app.myapp.vo.Assignment;
import app.util.DBConnectionPool;
@WebServlet("/assignment/add")
public class AssignmentAddServlet extends HttpServlet {

  private AssignmentDao assignmentDao;


    @Override
    public void init() throws ServletException {
        assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
    }

    @Override
  protected void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>과제</h1>");


  try {
      Assignment assignment = new Assignment();
      assignment.setTitle(request.getParameter("title "));
      assignment.setContent(request.getParameter("content? "));
      assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));

      assignmentDao.add(assignment);

      response.sendRedirect("/assignment/list");
      return;


  } catch (Exception e) {
    out.println("<p>과제 등록 오류!</p>");
    out.println("<pre>");
    e.printStackTrace(out);
    out.println("</pre>");
  }

    out.println("</body>");
    out.println("</html>");
  }
}
