package ramanda.ajisaka.asyraf.spring.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ramanda.ajisaka.asyraf.spring.mvc.model.HelloRequest;
import ramanda.ajisaka.asyraf.spring.mvc.model.HelloResponse;

@Controller
public class BodyController {
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping(
            path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String body(@RequestBody String reqBody) throws JsonProcessingException {
        HelloRequest request = objectMapper.readValue(reqBody, HelloRequest.class);
        HelloResponse response = new HelloResponse();
        response.setHello("Hello " + request.getName());
        return objectMapper.writeValueAsString(response);
    }
}
