package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!");

        return mav;
    }

    // @ResponseBody 를 사용하면 ViewResolver 를 실행하지않고 HTTP Message Body에 response/hello 가 그대로 보여 버린다.
    // @RestController도 마찬가지
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; //@ Controller 면서 String으로 반환하면 return 값이 논리적 뷰의 이름이 된다.
    }

    //추천하지 않는다. 불명확해서
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}