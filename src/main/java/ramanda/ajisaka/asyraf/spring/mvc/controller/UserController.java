package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import ramanda.ajisaka.asyraf.spring.mvc.model.User;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    public String getUser(
            @SessionAttribute(name = "user") User user
            ){
        return "Hello " + user.getUsername();
    }
}
