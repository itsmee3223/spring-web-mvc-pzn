package ramanda.ajisaka.asyraf.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ramanda.ajisaka.asyraf.spring.mvc.service.HelloService;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping(path = "/hello")
//    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
    public void helloWorld(@RequestParam(name = "name", required = false) String name, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
        String bodyResponse = helloService.hello(name);
        response.getWriter().println(bodyResponse);
    }
}
