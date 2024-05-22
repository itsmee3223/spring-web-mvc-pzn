package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableController {

    @GetMapping(path = "/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(
            @PathVariable("orderId") String orderId,
            @PathVariable("productId") String productId
    ){
        return "Order: " + orderId + " " + "Product: " + productId;
    }
}
