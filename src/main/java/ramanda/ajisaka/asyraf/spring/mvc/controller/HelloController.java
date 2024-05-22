package ramanda.ajisaka.asyraf.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ramanda.ajisaka.asyraf.spring.mvc.service.HelloService;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(path = "/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String bodyResponse = helloService.hello(name);
        response.getWriter().println(bodyResponse);
    }
}
