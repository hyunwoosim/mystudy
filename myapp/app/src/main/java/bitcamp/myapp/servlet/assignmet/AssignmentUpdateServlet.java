package bitcamp.myapp.servlet.assignmet;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/update")
public class AssignmentUpdateServlet extends HttpServlet {

    private AssignmentDao assignmentDao;
    private TransactionManager txManager;

    public AssignmentUpdateServlet() {
        DBConnectionPool connectionPool = new DBConnectionPool(
            "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
        this.assignmentDao = new AssignmentDaoImpl(connectionPool);
        this.txManager = new TransactionManager(connectionPool);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(" <!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println(" <meta charset='UTF-8'>");
        out.println(" <title>비트캠프 데브옵스 5기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>과제</h1>");

        try {
            int no = Integer.parseInt(request.getParameter("no"));

            Assignment assignment = assignmentDao.findBy(no);
            if (assignment == null) {
                out.println("<p>과제 번호가 유효하지 않습니다!</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            assignment.setTitle(request.getParameter("title"));
            assignment.setContent(request.getParameter("content"));

            txManager.startTransaction();
            assignmentDao.update(assignment);

            txManager.commit();
            out.println("<p>과제 변경했습니다.</p>");

        } catch (Exception e) {
            try {
                txManager.rollback();
            } catch (Exception e2) {
            }
            out.println("<p>과제 변경 중 오류 발생!</p>");
            out.println("<p>다시 시도하시기 바랍니다.</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");
    }

}
