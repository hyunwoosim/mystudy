package app.myapp.listener;

import app.myapp.dao.AssignmentDao;
import app.myapp.dao.AttachedFileDao;
import app.myapp.dao.BoardDao;
import app.myapp.dao.JJ_MemberDao;
import app.myapp.dao.mysql.AssignmentDaoImpl;
import app.myapp.dao.mysql.AttachedFileDaoImpl;
import app.myapp.dao.mysql.BoardDaoImpl;
import app.myapp.dao.mysql.JJMemberDaoImpl;
import app.util.DBConnectionPool;
import app.util.TransactionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("웹애플리케이션 자원 준비");

        DBConnectionPool connectionPool = new DBConnectionPool(
                "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

        AssignmentDao assignmentDao = new AssignmentDaoImpl(connectionPool);
        JJ_MemberDao jj_memberDao = new JJMemberDaoImpl(connectionPool);
        BoardDao boardDao = new BoardDaoImpl(connectionPool);
        AttachedFileDao attachedFileDao = new AttachedFileDaoImpl(connectionPool);
        TransactionManager txManager = new TransactionManager(connectionPool);

        ServletContext 웹애플리케이션저장소 = sce.getServletContext();
        웹애플리케이션저장소.setAttribute("assignmentDao", assignmentDao);
        웹애플리케이션저장소.setAttribute("jj_memberDao", jj_memberDao);
        웹애플리케이션저장소.setAttribute("boardDao", boardDao);
        웹애플리케이션저장소.setAttribute("attachedFileDado", attachedFileDao);
        웹애플리케이션저장소.setAttribute("txManager", txManager);
    }
}
