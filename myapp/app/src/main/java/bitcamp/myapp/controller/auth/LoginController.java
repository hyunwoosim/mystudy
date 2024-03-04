package bitcamp.myapp.controller.auth;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController implements PageController {

    MemberDao memberDao;

    public LoginController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        if (request.getMethod().equals("GET")) {

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("email")) {
                        request.setAttribute("email", cookie.getValue());
                        break;
                    }
                }
            }

            return "/auth/form.jsp";
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // include 서블릿에서는 쿠키를 응답헤더에 추가할 수 없다.
        // => 프론트 컨트롤러가 추가하게 하라!
        //
        ArrayList<Cookie> cookies = new ArrayList<>();
        String saveEmail = request.getParameter("saveEmail");
        if (saveEmail != null) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        request.setAttribute("cookies", cookies);

        Member member = memberDao.findByEmailAndPassword(email, password);

        if (member != null) {
            request.getSession().setAttribute("loginUser", member);
        }

        return "/auth/login.jsp";


    }
}