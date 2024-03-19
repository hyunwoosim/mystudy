package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/c01_2")
public class Controller01_2 {

    @GetMapping("h1")

    public String handler1(Model model) {

        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);

        return "c01_1";

    }

    @GetMapping("h2")
    public void handler2(Model model) {
        model.addAttribute("name", "홍길동2");
        model.addAttribute("age", 30);

        // view name  = /c01_2/h2
        // 최종 계산된 JSP경로 = /WEB-INF/jsp/ + c01_2/h2 + .jsp
//                             = /WEB-INF/jsp/c01_2/h2.jsp
    }


    @GetMapping("h3")
    public String handler3(Map<String, Object> map) {

        map.put("name", "홍길동3");
        map.put("age", 40);

        return "/WEB-INF/jsp/c01_1.jsp";

    }

}
