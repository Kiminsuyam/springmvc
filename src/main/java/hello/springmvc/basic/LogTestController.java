package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController //String이 그대로 반환이 된다. "ok"
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass()); //getClass() = LogTestController.class
// Slf4j가 위에있는 Logger log를 대신해준다.
    @RequestMapping("/log-test")
    public String logTest() {
        String name =   "Spring";

        System.out.println("name = " + name);


       // log.info(" info log=" + name);  //이렇게 사용하면 안된다.

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);  //개발사 같은 데서 보는
        log.info("info log={}", name);    //중요한 정보를 보는 것
        log.warn("warn log={}", name);    //위험한 것
        log.error("error log={}", name);  //에러
        return "ok";
    }

}
