package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    public String headerToken(@RequestHeader(name = "X-TOKEN") String token){
        if("Ramanda".equals(token)){
            return "OK";
        } else {
            return "KO";
        }
    }
}
